package com.free.exam.util;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Li Yu on 2017/6/21.
 */
@Component
public class Points24Util {
    public List<String> do24(int[] inputNums){
        if(inputNums.length!=4){
            return null;
        }

        String[] operater = {"+","-","*","/"};

        List<Integer> tmp = new ArrayList<Integer>();
        List<List<Integer>> combineRes = new ArrayList<List<Integer>>();
        List<List<Integer>> numsRes = new ArrayList<List<Integer>>();
        List<List<String>> operatorRes = new ArrayList<List<String>>();

        combine(inputNums, tmp, combineRes, inputNums.length);

        System.out.println(combineRes);
        //List<Double> calRes = new ArrayList<Double>();
        List<String> calParams = new ArrayList<String>();

        for(List<Integer> list : combineRes){

            List<Double> tmp1 = operate(list.get(0), list.get(1));

            for(int i=0; i<tmp1.size(); i++){

                List<Double> tmp2 = operate(tmp1.get(i),list.get(2));
                for(int j=0; j< tmp2.size(); j++){
                    List<Double> tmp3 = operate(tmp2.get(j),list.get(3));
                    for(int k=0; k<tmp3.size(); k++){
                        if(tmp3.get(k)==24.0){
                            List<String> operatorList =  new ArrayList<String>();
                            String tmpString = "";
                            operatorList.add(operater[i]);
                            operatorList.add(operater[j]);
                            operatorList.add(operater[k]);
                            operatorRes.add(operatorList);
                            numsRes.add(list);

                            tmpString = list.get(0)+operater[i]+list.get(1)+operater[j]+list.get(2)
                                    +operater[k]+list.get(3)+"="+tmp3.get(k);

                            //mode A+B*C(all)D need add a "()" in first operation
                            if(operater[i].equals("+")||operater[i].equals("-")){
                                if(operater[j].equals("*")||operater[j].equals("/")){
                                    tmpString = "("+list.get(0)+operater[i]+list.get(1)+")"+operater[j]+list.get(2)
                                            +operater[k]+list.get(3)+"="+tmp3.get(k);
                                }
                            }
                            //mode A(all)B+C*D need add a "()" in third operation
                            if(operater[j].equals("+")||operater[j].equals("-")){
                                if(operater[k].equals("*")||operater[k].equals("/")){
                                    tmpString = "("+list.get(0)+operater[i]+list.get(1)+operater[j]+list.get(2)+")"
                                            +operater[k]+list.get(3)+"="+tmp3.get(k);
                                }
                            }

                            calParams.add(tmpString);
                        }
                    }
                    //calRes.addAll(tmp3);
                }
            }
        }

        System.out.println(calParams);
        return calParams;
    }

    public List<Double> operate(double a, double b){
        List<Double> res = new ArrayList<Double>();

        res.add(a+b);
        res.add(a-b);
        res.add(a*b);
        res.add(a/b);

        return res;
    }

    void combine(int[] input, List<Integer> tmp, List<List<Integer>> res, int size){
        if(size == 0){
            //recursion end, add the result to the res list
            res.add(tmp);
        }
        for(int i=0; i<input.length; i++){
            //make a tmp list
            List<Integer> _tmp = new ArrayList<Integer>();
            //add the history numbers to tmp list
            _tmp.addAll(tmp);
            //see if the numbers is added or not
            if(!tmp.contains(input[i])){
                //add the num with col
                _tmp.add(input[i]);
                combine(input, _tmp, res, size-1);
            }
        }
    }
}
