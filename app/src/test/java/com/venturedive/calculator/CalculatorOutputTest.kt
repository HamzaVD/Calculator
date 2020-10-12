package com.venturedive.calculator

import com.venturedive.calculator.calculator.CalculatorOutputInterfaceView
import com.venturedive.calculator.calculator.CalculatorOutputPresentor
import org.junit.*
import org.mockito.*
import org.mockito.BDDMockito.then

class CalculatorOutputTest{
    private val mmPresenter : CalculatorOutputPresentor = CalculatorOutputPresentor
    private val mmMockView:CalculatorOutputInterfaceView = Mockito.mock(CalculatorOutputInterfaceView::class.java)

    @Test
    fun `1 plus 1 is 2`(){
        //Given that the view is attached
        mmPresenter.attach(mmMockView)

        //when a number is added
        mmPresenter.add("1")
        //then the correct equation should be set
        then(mmMockView).should().setEquation("1")

        //when an operator is added
        mmPresenter.add("+")
        //then the correct equation should be set
        then(mmMockView).should().setEquation("1+")

        //when another number is added
        mmPresenter.add("1")
        //then the correct equation should be set
        then(mmMockView).should().setEquation("1+1")
        then(mmMockView).should().setOutcome("2")
    }

    @Test
    fun `2 plus 2 minus 1  is 3`(){
        //clear Equation
        mmPresenter.clear()

        //Given that the view is attached
        mmPresenter.attach(mmMockView)

        //when a number is added
        mmPresenter.add("2")
        //then the correct equation should be set
        then(mmMockView).should().setEquation("2")

        //when an operator is added
        mmPresenter.add("+")
        //then the correct equation should be set
        then(mmMockView).should().setEquation("2+")

        //when another number is added
        mmPresenter.add("2")
        //then the correct equation should be set
        then(mmMockView).should().setEquation("2+2")
        then(mmMockView).should().setOutcome("4")

        //when another operator is added
        mmPresenter.add("-")
        //then the correct equation should be set
        then(mmMockView).should().setEquation("2+2-")
        then(mmMockView).should().setOutcome("4")

        //when another number is added
        mmPresenter.add("1")
        //then the correct equation should be set
        then(mmMockView).should().setEquation("2+2-1")
        then(mmMockView).should().setOutcome("3")
    }
}
