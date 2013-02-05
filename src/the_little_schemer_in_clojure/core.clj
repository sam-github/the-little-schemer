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
; I cribbed this from stackoverflow, and don't understand its syntax!
; Better to use fn.
;(defmacro lambda [args & body] `(fn ~(vec args) ~@body))

; #t -> true
; #f -> false
; cond/else -> cond/:else, but cond is a bit different in clojure


; Chapter 8

(def multirember&co (fn [a lat col] (cond
   (null? lat) (col (quote ()) (quote ()))
   (eq? (car lat) a) (multirember&co a (cdr lat) (fn [newlat seen] (col newlat (cons (car lat) seen))))
   :else (multirember&co a (cdr lat) (fn [newlat seen] (col (cons (car lat) newlat) seen))))))



; Partition a list into atom? and not atom?

(def atomics (fn [lat col]
	(cond
		(null? lat) (col () ())
		(atom? (car lat))
			(atomics (cdr lat) (fn [atoms lists] (col (cons (car lat) atoms) lists)))
		:else
			(atomics (cdr lat) (fn [atoms lists] (col atoms (cons (car lat) lists))))
	)
))

; (atomics '() list)
; (atomics '(1 2) list)
; (atomics '(1 (2) 3) list)

; Reverse a list, CPS possible?

