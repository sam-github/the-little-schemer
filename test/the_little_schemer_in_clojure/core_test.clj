(ns the-little-schemer-in-clojure.core-test
  (:use clojure.test
        the-little-schemer-in-clojure.core))

(deftest car-test
  (testing "car"
    (is (= 'a (car '(a b))))
    (is (= 'a (car '(a))))
    ))
    
(deftest cdr-test
  (testing "cdr"
    (is (= '(b c) (cdr '(a b c))))))
    
(deftest atom-test
  (testing "atom?"
    (is (= true  (atom? 1)))
    (is (= true  (atom? "1")))
    (is (= false (atom? '())))
    (is (= false (atom? '("1"))))
    ))

(deftest null-test
  (testing "null?"
    (is (= true  (null? '())))
    (is (= false (null? '(1))))
    (is (= false (null? '("a" 1))))
    ))

(deftest multirember&co-test
  (testing "multi_co"
    (is (= '(("b" "c") ("a")) (multirember&co "a" '("a", "b", "c") list)))))

