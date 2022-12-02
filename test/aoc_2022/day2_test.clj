(ns aoc-2022.day2-test
  (:require [clojure.test :refer :all]
            [aoc-2022.day2 :refer :all]))

(deftest hand-points-tests
  (is (= (hand-points :rock) 1))
  (is (= (hand-points :paper) 2))
  (is (= (hand-points :scissors) 3)))

(deftest round-score-tests
  (is (= (round-score :rock :rock) 3))
  (is (= (round-score :paper :paper) 3))
  (is (= (round-score :scissors :scissors) 3))
  (is (= (round-score :rock :paper) 0))
  (is (= (round-score :rock :scissors) 6))
  (is (= (round-score :paper :rock) 6))
  (is (= (round-score :paper :scissors) 0))
  (is (= (round-score :scissors :rock) 0))
  (is (= (round-score :scissors :paper) 6)))

(defn play-round-score-equal [me opponent expected-score]
  (= (play-round me opponent) expected-score))

(deftest play-round-score-tests
  (is (play-round-score-equal :rock :rock 4))
  (is (play-round-score-equal :rock :paper 1))
  (is (play-round-score-equal :rock :scissors 7))
  (is (play-round-score-equal :paper :rock 8))
  (is (play-round-score-equal :paper :paper 5))
  (is (play-round-score-equal :paper :scissors 2))
  (is (play-round-score-equal :scissors :rock 3))
  (is (play-round-score-equal :scissors :paper 9))
  (is (play-round-score-equal :scissors :scissors 6)))

(deftest lines-parse-tests
  (is (= (parse-lines-naive ["A X" "B Z" "C Y"]) [[:rock :rock] [:paper :scissors] [:scissors :paper]])))

(deftest compute-score-tests
  (is (= (compute-score-naive ["A Y"]) 8))
  (is (= (compute-score-naive ["A Y" "B X" "C Z"]) 15)))

(deftest compute-my-hand-tests
  (is (= (compute-hand :rock :draw) :rock))
  (is (= (compute-hand :rock :win) :paper))
  (is (= (compute-hand :rock :lose) :scissors)))

(deftest lines-parse-with-results-tests
  (is (= (parse-lines-results ["A X" "B Y" "C Z"]) [[:rock :lose] [:paper :draw] [:scissors :win]])))

(deftest compute-hands-tests
  (is (= (compute-hands [[:rock :lose] [:rock :draw] [:rock :win]]) [[:rock :scissors] [:rock :rock] [:rock :paper]])))