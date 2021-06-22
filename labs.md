# Lab Book

## Lab 1: Fizz Buzz

* Perform a Fizz Buzz TDD
* Test should be `FizzBuzzTest`
* Production should be `FizzBuzz`
* Think about the core of what is required
* You're the programmer, and you get to decide what to implement first.

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Italian_traffic_signs_-_fermarsi_e_dare_precedenza_-_stop.svg/1200px-Italian_traffic_signs_-_fermarsi_e_dare_precedenza_-_stop.svg.png" alt="drawing" width="10%" height="10%"/>

# Lab 2: Continue with CaesarShift

* Take your time, focus on one thing at a time
* Refactor along the way
* Run `mvn package` to view your coverage report
* Coverage report is located in `target/site/jacoco/index.html`

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Italian_traffic_signs_-_fermarsi_e_dare_precedenza_-_stop.svg/1200px-Italian_traffic_signs_-_fermarsi_e_dare_precedenza_-_stop.svg.png" alt="drawing" width="10%" height="10%"/>

# Lab 3: Completing the Domain

* In `com.xyzcorp.student.registration`, create a `StudentServiceTest`
* `StudentService` 
  * Service/Facade class.
  * Should contain a method called `registerStudent` that will take a `firstName`, `lastName`, and `studentID` as a String (e.g. "001");
  * `registerStudent` should do two things.
     * Call `studentDAO.findByStudentId(studentID);` and determine if the student is already in the database
     * If the student already in the database, do not persist that student.
     * If they are not in the database, then you should persist the student into the database.
* **Bonus** Combine `StudentService` and `MySQLDAORefactorTwo` and using TestContainer, create an integration test that verifies that your `StudentService` works

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Italian_traffic_signs_-_fermarsi_e_dare_precedenza_-_stop.svg/1200px-Italian_traffic_signs_-_fermarsi_e_dare_precedenza_-_stop.svg.png" alt="drawing" width="10%" height="10%"/>

# Lab 4: Working on Library Books Together

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Italian_traffic_signs_-_fermarsi_e_dare_precedenza_-_stop.svg/1200px-Italian_traffic_signs_-_fermarsi_e_dare_precedenza_-_stop.svg.png" alt="drawing" width="10%" height="10%"/>


# Lab 5: Blackjack

* Using some refactoring techniques, we will create a `Hand` class that represents a `Hand`
* Make sure the tests continue to pass as you do the refactoring steps.
* You may need to update the structure of tests along the way.
* Copy and Paste the `List<Card>` hand field to a new class called `Hand`
* Replace the List of `Card` with an instance of the new Hand class.
* In `Hand`: create a getter to access to the collection. Note: this getter is temporary!
* In `Game`: do a Search & Replace to replace the use of the original collection with the getter from the Hand class
* Find usages of `Hand`’s collection getter (using CMD+B or CTRL+B on the get method)
* For each usage found, use Extract Method and Move Method refactorings (and possibly Inline Method and Introduce Parameter) to move the usage to the Hand class
* Continue finding usages and moving methods until there is no more external use of the collection getter
* Inline & remove getter from the Hand class.

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Italian_traffic_signs_-_fermarsi_e_dare_precedenza_-_stop.svg/1200px-Italian_traffic_signs_-_fermarsi_e_dare_precedenza_-_stop.svg.png" alt="drawing" width="10%" height="10%"/>

# Lab 6: Wrap Class

* Using some refactoring techniques we learned, slowly and methodically add some auditing to the `Deck` class
* **DO NOT TOUCH THE `Deck` class**
* This is an exercise to work around a class that perhaps you don't have access to, or you that you just don't want to change
* Use the _Wrap Class_ procedure around `draw()`
* In your wrap class use a `List<String>` to hold the all the changes of the deck. Strings can have the time, and should look something like this:

"2021-04-01 08:00:01 -6:00 Draw: Card{suit=HEARTS, rank=TEN} Size: 51"  
"2021-04-01 08:00:04 -6:00 Draw: Card{suit=SPADES, rank=ACE} Size: 50"

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Italian_traffic_signs_-_fermarsi_e_dare_precedenza_-_stop.svg/1200px-Italian_traffic_signs_-_fermarsi_e_dare_precedenza_-_stop.svg.png" alt="drawing" width="10%" height="10%"/>


