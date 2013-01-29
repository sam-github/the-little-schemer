(ns the-little-schemer-in-clojure.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

; The scheme primitives

; car/cdr are first/rest
(def car first)
(def cdr rest)

; First is defined over collections, thefore it is undefined over not collections
(defn atom? [a] (not (coll? a)))

; http://juliangamble.com/blog/2012/07/20/the-little-schemer-in-clojure-chapter-1/
; Suggests using seq? instead of coll?, and then points to this, which I don't understand:
;  http://clojure.org/lazy

; http://hyperpolyglot.org/lisp
;   says cljr has list?, so atom? would be not list?

; A collection is null? when the rest is nil
(defn null? [l] (nil? (next l)))

; cljr has empty?

; Identicality is called eq? in scheme, identical? in clojure
(def eq? identical?)

; lambda -> fn
; #t -> true
; #f -> false

