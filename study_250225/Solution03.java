package Devcos.AIBE.study_250225;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution03 {
    public static void main(String[] args) {
        Solution03 sol = new Solution03();
        String[] cases = {
                "()()", "(())()", ")()(", "(()(", "()())", "())(()"
        };
        boolean[] answers = {
                true, true, false, false, false, false
        };
        for (int i = 0; i < cases.length; i++) {
            System.out.printf("""
                    case%d (%s) : %s
                    """,
//                    i, cases[i], answers[i] == sol.solution(cases[i]) ? "PASS" : "FAIL");
                    i, cases[i], answers[i] == sol.solution2(cases[i]) ? "PASS" : "FAIL");
        }
    }

    boolean solution2(String s) {
        // import java.util.*;
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
//            if (c == '(') {
            if (c == 40) {
                stack.push(c); // 여는 괄호 넣기 (최신에 들어온 무언가)
//                System.out.println("stack = " + stack);
                continue;
            }
            if (stack.isEmpty()) { // 더 이상 여는 괄호가 없는 상태
                return false;
            }
            stack.pop(); // 꺼내서 짝을 맞춘다
            // 변수 하나가 사라짐.
        }
        return stack.isEmpty(); // 스택 안에 남은 여는 괄호가 없다
    }

    boolean solution(String s) {
        // 1. 열린 괄호 없이 닫힌 괄호가 등장 (x)
        // 2. 나중에 보니까 열린 괄호가 닫힌 괄호보다 많아 (x)
        // 3. ......(???)
        // 근본적인 원리란 무엇인가?
        int openBracketCounting = 0;
        for (char c : s.toCharArray()) { // 문자열 -> char -> 묶음(배열)
            System.out.println("c = " + c);
//            if (c == '(') { // 작은따옴표? char.
            if (c == 40) { // 작은따옴표? char.
                openBracketCounting++; // 늘려주면 된다.
                System.out.println("openBracketCounting = " + openBracketCounting);
                continue; // 강사님은 else가 싫다고 하셨어 (forEach와 else에 코딩 스타일 강요하지 말아주세요?)
                // 이렇게 흐름제어를 할 수 있는 상황에서는 else, else if 코드는 '클-린'하지 않음.
                // return, break, continue로 여기까지만 하고 뒤는 맡길게 할 수 있으면...
            }
            // (, )
            // if (c== ')')
            // 여기서부터 무조건 닫는 괄호
            if (openBracketCounting == 0) {
                System.out.println("여는 괄호 없이 닫는 괄호 등장");
                return false;
            }
            // 닫는 괄호가 등장하면 카운트를 감소
            openBracketCounting--;
        }
        // 만약에 모든 괄호가 짝을 이루었다면?
        return openBracketCounting == 0;
    }
}

//

// 이 코드 바탕으로 스택이라는 자료구조를 모르는 사람 대상으로 중학생/비전공자를 포커스하여 그 과정을 한줄한줄 설명해주고 시각자료나 영상자료가 있다면 제공해줘.
class Solution0301 {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
//            if (c == '(') {
            if (c == 40) {
                stack.push(c); // 여는 괄호 넣기 (최신에 들어온 무언가)
//                System.out.println("stack = " + stack);
                continue;
            }
            if (stack.isEmpty()) { // 더 이상 여는 괄호가 없는 상태
                return false;
            }
            stack.pop(); // 꺼내서 짝을 맞춘다
            // 변수 하나가 사라짐.
        }
        return stack.isEmpty();
    }
}