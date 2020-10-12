package com.venturedive.calculator.calculator

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.venturedive.calculator.R
import kotlinx.android.synthetic.main.view_calculator_output.view.*

class CalculatorOutputView(context: Context, attributeSet: AttributeSet): LinearLayout(context, attributeSet), CalculatorOutputInterfaceView{
    init {
        orientation = VERTICAL

        gravity = Gravity.CENTER_VERTICAL

        LayoutInflater.from(context).inflate(R.layout.view_calculator_output,this, true )
    }

    fun addItem(item: String){
        CalculatorOutputPresentor.add(item)
    }
    fun reomveItem(){
        CalculatorOutputPresentor.reomve()
    }
    fun solve(){
        CalculatorOutputPresentor.solve()
    }
    fun clear(){
        CalculatorOutputPresentor.clear()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        CalculatorOutputPresentor.attach(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        CalculatorOutputPresentor.detach()
    }

    override fun setEquation(equation: String) {
        calculator_input_equation.text = equation
    }

    override fun setOutcome(outcome: String) {
        calculator_input_outcome.text = outcome
    }
}