(ns the-little-schemer-in-clojure.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

; Another little schemer:
;   https://github.com/midpeter444/little-schemer/blob/master/clojure/littleclj.clj

; The scheme primitives

; car/cdr are first/rest
(def car first)
(def cdr rest)

; First is defined over collections, thefore it is undefined over not collections
(defn atom? [a] (not (coll? a)))

; http://juliangamble.com/blog/2012/07/20/the-little-schemer-in-clojure-chapter-1/
; Suggests using seq? instead of coll?, and then points to this, which I don't understand:
;  http://clojure.org/lazy

; A collection is null? when it is empty?
(def null? empty?)

; Identicality is called eq? in scheme, identical? in clojure
(def eq? identical?)

; lambda -> fn
; #t -> true
; #f -> false

; Chapter 8

(def multirember&co (fn [a lat col] (cond
   (null? lat) (col (quote ()) (quote ()))
   (eq? (car lat) a) (multirember&co a (cdr lat) (fn [newlat seen] (col newlat (cons (car lat) seen))))
   :else (multirember&co a (cdr lat) (fn [newlat seen] (col (cons (car lat) newlat) seen))))))


