(comment
  Copyright (C) 2010 Roland Tritsch

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  )

(comment
  Solving the problem with a very simple recursive algorithm that treats
  a list as a/the ring of poeple/soldiers and either append a/the current
  soldier again at the end or eliminates the current soldier from the list.
  )

(ns ^{:doc "A solution to the Josephus Problem"
      :author "roland@tritsch.org"
      }
  org.tritsch.josephus
  (:gen-class))

(defn append "Append the first soldier to the tail of the list again"
  ([soldiers] (concat (rest soldiers) (list (first soldiers)))))

(defn eliminate "Eliminate the first soldier from the list"
  ([soldiers] (rest soldiers)))

(defn advance "Advance through the list/circle until only one soldier is left over"
  ([soldiers killRate] (advance soldiers killRate 1))
  ([soldiers killRate counter]
     (println counter ":" soldiers)
     (cond
      (= (count soldiers) 1) soldiers
      (= (mod counter killRate) 0) (advance (eliminate soldiers) killRate (inc counter))
      :else (advance (append soldiers) killRate (inc counter)))))

(defn solve "Solve the Josephus Problem"
  ([numberOfSoldiers killRate] (advance (range 1 (+ numberOfSoldiers 1)) killRate)))

; --- Java Stuff

(defn usage "Describe usage()"
  ([] (println "Usage: josephus numberOfSoldiers killRate")))

(defn -main "Java Main Function"
  ([& args]
     (do
       (usage)
       (solve
	(read-string (nth args 0))
	(read-string (nth args 1))))))
