package racingame.controller

import racingame.domain.Car
import racingame.domain.Cars
import racingame.domain.RacingGame
import racingame.view.InputView
import racingame.view.OutputView

class GameController(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    fun start() {
        val nameOfCars = inputView.requestNameOfCars()
        val totalTrialCount: Int = inputView.requestCountOfTrial()

        outputView.printResult()
        val racingGame = RacingGame(createCars(nameOfCars), totalTrialCount)
        val winner = racingGame.run()

        outputView.printRacingHistories(racingGame.racingHistories)
        outputView.printWinner(winner.nameOfWinners)
    }

    private fun createCars(nameOfCars: List<String>) = Cars(nameOfCars.map { Car(it) })
}
