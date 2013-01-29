(ns the-little-schemer-in-clojure.core-test
  (:use clojure.test
        the-little-schemer-in-clojure.core))

(deftest car-test
  (testing "car"
    (is (= 'a (car '(a b))))))
    
(deftest cdr-test
  (testing "cdr"
    (is (= '(b c) (cdr '(a b c))))))
    
(deftest atom-test
  (testing "atom?"
    (is (= true (atom? 1)))))

(deftest not-atom-test
  (testing "not atom?"
    (is (= false (atom? '(1 2))))))

(deftest null-test
  (testing "null?"
    (is (= true (null? '())))))

(deftest not-null-test
  (testing "not null?"
    (is (= false (null? '(1 2))))))

    
    
    
    
