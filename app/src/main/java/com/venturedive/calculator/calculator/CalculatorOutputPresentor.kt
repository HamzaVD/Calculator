package com.venturedive.calculator.calculator

import bsh.Interpreter
import java.lang.Exception

object CalculatorOutputPresentor {
    // Current Attached View
    private var mmView: CalculatorOutputInterfaceView?= null
    // Current equation
    private var mCurrentEquation: String = ""
    // Current outcome
    private var mCurrentOutcome: String = ""
    // Interpretor
    private val mInterpreter = Interpreter()

    fun attach(view: CalculatorOutputInterfaceView){
        mmView = view
        updateEquation()
        updateOutcome()
    }
    fun detach(){
        mmView = null
    }
    fun add(item: String){
        mCurrentEquation = mCurrentEquation.plus(item)
        updateEquation()
        calculateOutcome()
        updateOutcome()
    }
    fun reomve(){
        mCurrentEquation = if(mCurrentEquation.length>1){
            mCurrentEquation.substring(0, mCurrentEquation.length-1)
        } else{
            ""
        }
        updateEquation()
        calculateOutcome()
        updateOutcome()
    }
    fun solve(){
        if(mCurrentOutcome.isNotEmpty()){
            mCurrentEquation = mCurrentOutcome
            mCurrentOutcome = ""
        }
        updateEquation()
        updateOutcome()
    }
    fun clear(){
        mCurrentEquation = ""
        mCurrentOutcome = ""
        updateEquation()
        updateOutcome()
    }
    private fun calculateOutcome(){
        if(mCurrentEquation.isNotEmpty()){
            try{
                mInterpreter.eval("result = $mCurrentEquation")
                val result = mInterpreter.get("result")
                if(result != null && result is Int){
                    mCurrentOutcome = result.toString()
                }
            }
            catch (e: Exception){
                mCurrentOutcome  =""
            }
        }else{
            mCurrentOutcome = ""
        }
    }
    private fun updateEquation(){
        mmView?.setEquation(mCurrentEquation)
    }
    private fun updateOutcome(){
        mmView?.setOutcome(mCurrentOutcome)
    }
}