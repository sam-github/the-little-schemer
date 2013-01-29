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

; A collection is null? when the rest is nil
(defn null? [l] (nil? (next l)))

; Identicality is called eq? in scheme, identical? in clojure
(def eq? identical?)

; lambda -> fn
; #t -> true
; #f -> false

