package com.hodzi.stackviewer.questions.detail

import android.os.Bundle
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.core.BasePresenter
import com.hodzi.stackviewer.model.Data
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.questions.QuestionsInteractor
import com.hodzi.stackviewer.questions.detail.QuestionDetailActivity.Companion.EXTRA_QUESTION
import com.hodzi.stackviewer.utils.Shared
import com.hodzi.stackviewer.utils.Strings
import com.hodzi.stackviewer.utils.Vote
import io.reactivex.Observable

class QuestionDetailPresenter(private val questionsInteractor: QuestionsInteractor,
                              val shared: Shared) :
    BasePresenter<QuestionDetailContract.View>(), QuestionDetailContract.Presenter {

    lateinit var question: Question

    override fun parseArguments(extras: Bundle) {
        super.parseArguments(extras)
        question = bundle?.getSerializable(EXTRA_QUESTION) as Question
    }

    override fun attach(view: QuestionDetailContract.View, bundle: Bundle?) {
        super.attach(view, bundle)
        this.view?.showQuestion(question)
    }

    override fun loadData() {
        baseObservableListDefaultError(questionsInteractor.getQuestionAnswers(question.questionId),
            { block ->
                view?.showArray(block.items.toTypedArray())
            })
    }

    override fun vote(id: Int, vote: Vote) {
        if (Strings.isEmptyString(shared.getToken())) {
            view?.goToAuth()
            return
        }

        val observable: Observable<out Data> = when (vote) {
            Vote.ANSWER_UP     -> {
                questionsInteractor.answerUpVote(id, shared.getToken())
            }
            Vote.ANSWER_DOWN   -> {
                questionsInteractor.answerDownVote(id, shared.getToken())
            }
            Vote.QUESTION_UP   -> {
                questionsInteractor.questionUpVote(id, shared.getToken())
            }
            Vote.QUESTION_DOWN -> {
                questionsInteractor.questionDownVote(id, shared.getToken())
            }
        }
        baseObservableData(observable,
            { data ->
                run {
                    view?.voiceAccepted()
                }
            },
            { throwable ->
                run {
                    view?.showError(R.string.error_obsolete)
                }
            }
        )
    }
}
