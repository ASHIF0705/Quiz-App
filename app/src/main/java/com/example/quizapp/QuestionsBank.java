package com.example.quizapp;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    public static List<Question> getQuestions(String category, String level) {
        List<Question> questions = new ArrayList<>();

        switch (category) {
            case "sports":
                questions = getSportsQuestions(level);
                break;
            case "gk":
                questions = getGeneralKnowledgeQuestions(level);
                break;
            case "programming":
                questions = getProgrammingQuestions(level);
                break;
        }

        while (questions.size() < 15) {
            if (!questions.isEmpty()) {
                questions.add(questions.get(0));
            } else {
                questions.add(new Question("Default Question", new String[]{"A", "B", "C", "D"}, 0));
            }
        }

        return questions;
    }

    //Sports
    private static List<Question> getSportsQuestions(String level) {
        List<Question> list = new ArrayList<>();

        if (level.equals("easy")) {
            list.add(new Question("How many players are on a football team on the field?", new String[]{"9", "10", "11", "12"}, 2));
            list.add(new Question("Which sport is played at Wimbledon?", new String[]{"Cricket", "Tennis", "Football", "Badminton"}, 1));
            list.add(new Question("How many rings are in the Olympic symbol?", new String[]{"4", "5", "6", "7"}, 1));
            list.add(new Question("What is the shape of a rugby ball?", new String[]{"Round", "Oval", "Square", "Triangle"}, 1));
            list.add(new Question("In cricket, how many runs for hitting the ball to the boundary?", new String[]{"4", "6", "2", "1"}, 0));
            list.add(new Question("Which sport uses a shuttlecock?", new String[]{"Tennis", "Badminton", "Table Tennis", "Squash"}, 1));
            list.add(new Question("How long is a standard football match?", new String[]{"60 minutes", "90 minutes", "120 minutes", "45 minutes"}, 1));
            list.add(new Question("Which country invented basketball?", new String[]{"USA", "Canada", "China", "India"}, 1));
            list.add(new Question("How many players in a volleyball team on court?", new String[]{"5", "6", "7", "8"}, 1));
            list.add(new Question("What color is the jersey of the Tour de France leader?", new String[]{"Yellow", "Green", "Red", "White"}, 0));
            list.add(new Question("How many players in a Kabaddi team?", new String[]{"7", "9", "11", "12"}, 0));
            list.add(new Question("Which country has won the most FIFA World Cups?", new String[]{"Germany", "Brazil", "Italy", "Argentina"}, 1));
            list.add(new Question("In which sport is 'dribbling' most common?", new String[]{"Cricket", "Basketball", "Tennis", "Hockey"}, 1));
            list.add(new Question("What is the national sport of Japan?", new String[]{"Karate", "Sumo", "Baseball", "Judo"}, 1));
            list.add(new Question("How many players in a hockey team on ice?", new String[]{"5", "6", "7", "11"}, 1));
        }
        else if (level.equals("medium")) {
            list.add(new Question("Who won the FIFA World Cup in 2022?", new String[]{"France", "Brazil", "Argentina", "Germany"}, 2));
            list.add(new Question("Which country has won the most Cricket World Cups?", new String[]{"India", "Australia", "West Indies", "England"}, 1));
            list.add(new Question("In which year did India win its first Cricket World Cup?", new String[]{"1975", "1983", "2007", "2011"}, 1));
            list.add(new Question("Who won the Ballon d'Or in 2023?", new String[]{"Lionel Messi", "Kylian Mbappé", "Erling Haaland", "Karim Benzema"}, 0));
            list.add(new Question("Which team won the IPL in 2024?", new String[]{"CSK", "KKR", "MI", "RCB"}, 1));
            list.add(new Question("Who holds the record for most international centuries in cricket?", new String[]{"Sachin Tendulkar", "Virat Kohli", "Ricky Ponting", "Jacques Kallis"}, 1));
            list.add(new Question("Which Indian won the first individual Olympic gold medal?", new String[]{"Abhinav Bindra", "Neeraj Chopra", "PV Sindhu", "Saina Nehwal"}, 0));
            list.add(new Question("What is the distance of a marathon race in kilometers?", new String[]{"26.2", "42.195", "50", "30"}, 1));
            list.add(new Question("Who won the Wimbledon men's singles in 2024?", new String[]{"Novak Djokovic", "Carlos Alcaraz", "Jannik Sinner", "Rafael Nadal"}, 1));
            list.add(new Question("In which sport is the Thomas Cup played?", new String[]{"Badminton", "Tennis", "Table Tennis", "Squash"}, 0));
            list.add(new Question("Which country hosts the Ashes cricket series?", new String[]{"Australia & England", "India & Australia", "England & South Africa", "West Indies & England"}, 0));
            list.add(new Question("Who is the highest run-scorer in IPL history?", new String[]{"Virat Kohli", "Shikhar Dhawan", "Rohit Sharma", "David Warner"}, 0));
            list.add(new Question("How many medals did India win in Tokyo Olympics 2020?", new String[]{"5", "7", "8", "9"}, 1));
            list.add(new Question("Which sport uses the term 'hole-in-one'?", new String[]{"Golf", "Tennis", "Cricket", "Billiards"}, 0));
            list.add(new Question("Who is the fastest man to 100 Test wickets in cricket?", new String[]{"Jasprit Bumrah", "Rashid Khan", "Pat Cummins", "Kagiso Rabada"}, 1));
        }
        else if (level.equals("challenge")) {
            list.add(new Question("Who is the only cricketer to score 100 international centuries?", new String[]{"Sachin Tendulkar", "Virat Kohli", "Ricky Ponting", "Kumar Sangakkara"}, 0));
            list.add(new Question("Who won the first modern Olympic Games gold medal?", new String[]{"James Connolly", "Carl Lewis", "Jesse Owens", "Al Oerter"}, 0));
            list.add(new Question("Who has the most Grand Slam singles titles in men's tennis (2026)?", new String[]{"Roger Federer", "Rafael Nadal", "Novak Djokovic", "Pete Sampras"}, 2));
            list.add(new Question("Which country has never won the FIFA World Cup?", new String[]{"Portugal", "Netherlands", "Hungary", "Mexico"}, 1));
            list.add(new Question("Who is the youngest player to score a Test century?", new String[]{"Prithvi Shaw", "Liton Das", "Shafali Verma", "Sachithra Senanayake"}, 0));
            list.add(new Question("Who was the first Indian woman to win Olympic wrestling medal?", new String[]{"Sakshi Malik", "Vinesh Phogat", "Bajrang Punia", "Aman Sehrawat"}, 0));
            list.add(new Question("Who holds the record for fastest 50 in IPL history?", new String[]{"KL Rahul", "Yusuf Pathan", "Nicholas Pooran", "Kieron Pollard"}, 1));
            list.add(new Question("In which year was the first T20 World Cup held?", new String[]{"2005", "2007", "2009", "2010"}, 1));
            list.add(new Question("Who is the only player to win FIFA World Cup as player and coach?", new String[]{"Franz Beckenbauer", "Didier Deschamps", "Mario Zagallo", "Both A & C"}, 3));
            list.add(new Question("What is the longest winning streak in NBA history?", new String[]{"33", "37", "72", "88"}, 1));
            list.add(new Question("Who won the first Formula 1 World Championship?", new String[]{"Juan Manuel Fangio", "Giuseppe Farina", "Alberto Ascari", "Mike Hawthorn"}, 1));
            list.add(new Question("Which boxer has the most career knockouts?", new String[]{"Mike Tyson", "George Foreman", "Joe Louis", "Archie Moore"}, 3));
            list.add(new Question("In which sport would you perform a 'Grand Jeté'?", new String[]{"Figure Skating", "Gymnastics", "Ballet", "Diving"}, 2));
            list.add(new Question("Who is the only cricketer to score 400 in a Test innings?", new String[]{"Brian Lara", "Matthew Hayden", "Virender Sehwag", "Don Bradman"}, 0));
            list.add(new Question("Which country won the most medals in Paris Olympics 2024?", new String[]{"USA", "China", "France", "Great Britain"}, 0));
        }

        return list;
    }

    // General Knowledge
    private static List<Question> getGeneralKnowledgeQuestions(String level) {
        List<Question> list = new ArrayList<>();

        if (level.equals("easy")) {
            list.add(new Question("What is the capital of India?", new String[]{"Mumbai", "Delhi", "Kolkata", "Chennai"}, 1));
            list.add(new Question("How many continents are there on Earth?", new String[]{"5", "6", "7", "8"}, 2));
            list.add(new Question("Which planet is known as the Red Planet?", new String[]{"Venus", "Mars", "Jupiter", "Saturn"}, 1));
            list.add(new Question("What is the national animal of India?", new String[]{"Lion", "Tiger", "Elephant", "Peacock"}, 1));
            list.add(new Question("Which is the largest ocean in the world?", new String[]{"Atlantic", "Indian", "Pacific", "Arctic"}, 2));
            list.add(new Question("What is the currency of Japan?", new String[]{"Yuan", "Won", "Yen", "Ringgit"}, 2));
            list.add(new Question("How many days are in a leap year?", new String[]{"365", "366", "364", "360"}, 1));
            list.add(new Question("Which is the tallest mountain in the world?", new String[]{"K2", "Mount Everest", "Kangchenjunga", "Lhotse"}, 1));
            list.add(new Question("What is the chemical symbol for Gold?", new String[]{"Au", "Ag", "Fe", "Cu"}, 0));
            list.add(new Question("What is the national flower of India?", new String[]{"Rose", "Lotus", "Sunflower", "Jasmine"}, 1));
            list.add(new Question("Which animal is known as the King of the Jungle?", new String[]{"Tiger", "Lion", "Elephant", "Bear"}, 1));
            list.add(new Question("How many colors are in a rainbow?", new String[]{"6", "7", "8", "5"}, 1));
            list.add(new Question("What is the longest river in India?", new String[]{"Yamuna", "Ganga", "Brahmaputra", "Godavari"}, 1));
            list.add(new Question("Which is the smallest continent?", new String[]{"Australia", "Europe", "Antarctica", "South America"}, 0));
            list.add(new Question("What is the currency of the United States?", new String[]{"Dollar", "Euro", "Pound", "Yen"}, 0));
        }
        else if (level.equals("medium")) {
            list.add(new Question("Who wrote the Indian national anthem?", new String[]{"Rabindranath Tagore", "Bankim Chandra", "Sarojini Naidu", "Subhas Chandra Bose"}, 0));
            list.add(new Question("In which year did India gain independence?", new String[]{"1945", "1947", "1950", "1942"}, 1));
            list.add(new Question("Who discovered penicillin?", new String[]{"Alexander Fleming", "Louis Pasteur", "Marie Curie", "Thomas Edison"}, 0));
            list.add(new Question("What is the boiling point of water in Celsius?", new String[]{"90", "100", "110", "120"}, 1));
            list.add(new Question("Which country has the largest population in 2026?", new String[]{"China", "India", "USA", "Indonesia"}, 1));
            list.add(new Question("Who painted the Mona Lisa?", new String[]{"Michelangelo", "Leonardo da Vinci", "Raphael", "Van Gogh"}, 1));
            list.add(new Question("What is the hardest natural substance on Earth?", new String[]{"Gold", "Iron", "Diamond", "Platinum"}, 2));
            list.add(new Question("Which vitamin is produced by sunlight?", new String[]{"Vitamin A", "Vitamin B", "Vitamin C", "Vitamin D"}, 3));
            list.add(new Question("Who is known as the Father of the Indian Constitution?", new String[]{"Mahatma Gandhi", "Jawaharlal Nehru", "B.R. Ambedkar", "Sardar Patel"}, 2));
            list.add(new Question("What is the full form of DNA?", new String[]{"Deoxyribonucleic Acid", "Daily Nucleic Acid", "Deoxyribose Nitrogen Acid", "None"}, 0));
            list.add(new Question("Which is the largest mammal in the world?", new String[]{"Elephant", "Blue Whale", "Giraffe", "Hippopotamus"}, 1));
            list.add(new Question("In which year did the first man land on the moon?", new String[]{"1967", "1969", "1971", "1975"}, 1));
            list.add(new Question("What is the currency of the United Kingdom?", new String[]{"Dollar", "Euro", "Pound Sterling", "Franc"}, 2));
            list.add(new Question("Which element has atomic number 1?", new String[]{"Helium", "Hydrogen", "Lithium", "Carbon"}, 1));
            list.add(new Question("Which is the largest desert in the world?", new String[]{"Sahara", "Gobi", "Antarctic", "Kalahari"}, 2));
        }
        else if (level.equals("challenge")) {
            list.add(new Question("Who was the first woman to win a Nobel Prize?", new String[]{"Marie Curie", "Mother Teresa", "Jane Addams", "Pearl Buck"}, 0));
            list.add(new Question("Which letter does not appear on the periodic table?", new String[]{"J", "Q", "X", "Z"}, 0));
            list.add(new Question("Which country has the most time zones?", new String[]{"Russia", "USA", "France", "China"}, 2));
            list.add(new Question("Who wrote 'The Origin of Species'?", new String[]{"Charles Darwin", "Gregor Mendel", "Alfred Wallace", "Thomas Huxley"}, 0));
            list.add(new Question("What is the deepest point in the ocean?", new String[]{"Mariana Trench", "Challenger Deep", "Puerto Rico Trench", "Tonga Trench"}, 1));
            list.add(new Question("In which year did the Berlin Wall fall?", new String[]{"1987", "1989", "1991", "1993"}, 1));
            list.add(new Question("What is the only bird that can fly backwards?", new String[]{"Hummingbird", "Eagle", "Owl", "Parrot"}, 0));
            list.add(new Question("Which planet has the most moons in 2026?", new String[]{"Jupiter", "Saturn", "Uranus", "Neptune"}, 1));
            list.add(new Question("What is the SI unit of electric current?", new String[]{"Volt", "Ampere", "Watt", "Ohm"}, 1));
            list.add(new Question("Which is the only continent without an active volcano?", new String[]{"Australia", "Europe", "Africa", "Antarctica"}, 0));
            list.add(new Question("Who was the first female Prime Minister of India?", new String[]{"Indira Gandhi", "Sonia Gandhi", "Pratibha Patil", "Sarojini Naidu"}, 0));
            list.add(new Question("What is the rarest blood type in the world?", new String[]{"O-", "AB-", "B+", "A+"}, 1));
            list.add(new Question("Who discovered the theory of relativity?", new String[]{"Isaac Newton", "Albert Einstein", "Stephen Hawking", "Galileo Galilei"}, 1));
            list.add(new Question("Which element is named after Marie Curie?", new String[]{"Einsteinium", "Curium", "Bohrium", "Fermium"}, 1));
            list.add(new Question("What is the only letter not on the periodic table?", new String[]{"J", "Q", "X", "Z"}, 0));
        }

        return list;
    }

    // Programming
    private static List<Question> getProgrammingQuestions(String level) {
        List<Question> list = new ArrayList<>();

        if (level.equals("easy")) {
            list.add(new Question("What is the file extension for Python files?", new String[]{".java", ".py", ".js", ".cpp"}, 1));
            list.add(new Question("Which HTML tag is used for the largest heading?", new String[]{"<h6>", "<h1>", "<head>", "<title>"}, 1));
            list.add(new Question("What is the full form of HTML?", new String[]{"Hyper Text Markup Language", "High Text Markup Language", "Hyper Transfer Markup Language", "Home Text Markup Language"}, 0));
            list.add(new Question("How do you print 'Hello' in Python?", new String[]{"print('Hello')", "echo('Hello')", "console.log('Hello')", "System.out.println('Hello')"}, 0));
            list.add(new Question("Which symbol is used for single-line comment in Java?", new String[]{"//", "#", "/*", "<!--"}, 0));
            list.add(new Question("What is used to store multiple values in Python?", new String[]{"array", "list", "tuple", "All of the above"}, 3));
            list.add(new Question("Which language is primarily used for Android apps?", new String[]{"Python", "Java/Kotlin", "C#", "Swift"}, 1));
            list.add(new Question("What does CSS stand for?", new String[]{"Creative Style Sheets", "Cascading Style Sheets", "Computer Style Sheets", "Colorful Style Sheets"}, 1));
            list.add(new Question("Which company originally developed Java?", new String[]{"Microsoft", "Sun Microsystems", "Google", "Apple"}, 1));
            list.add(new Question("How do you make a comment in Python?", new String[]{"//", "#", "/* */", "<!-- -->"}, 1));
            list.add(new Question("Which symbol ends a statement in Java?", new String[]{";", ":", ".", ","}, 0));
            list.add(new Question("What is used to change text color in HTML?", new String[]{"color", "font-color", "text-color", "style-color"}, 0));
            list.add(new Question("Which is not a programming language?", new String[]{"Python", "Java", "HTML", "C++"}, 2));
            list.add(new Question("What is the output of 2 + 3 * 4?", new String[]{"20", "14", "11", "24"}, 1));
            list.add(new Question("Which HTML tag creates a line break?", new String[]{"<br>", "<lb>", "<break>", "<newline>"}, 0));
        }
        else if (level.equals("medium")) {
            list.add(new Question("Who created the Python programming language?", new String[]{"Dennis Ritchie", "Guido van Rossum", "James Gosling", "Brendan Eich"}, 1));
            list.add(new Question("Which HTML tag is used to create a hyperlink?", new String[]{"<link>", "<a>", "<href>", "<url>"}, 1));
            list.add(new Question("In Java, which keyword is used to prevent inheritance?", new String[]{"final", "static", "abstract", "private"}, 0));
            list.add(new Question("What does the 'len()' function return in Python?", new String[]{"Length", "Size", "Count", "All of the above"}, 0));
            list.add(new Question("Which method adds an element to an ArrayList in Java?", new String[]{"add()", "push()", "append()", "insert()"}, 0));
            list.add(new Question("What is the default value of a boolean in Java?", new String[]{"true", "false", "null", "0"}, 1));
            list.add(new Question("Which CSS property changes the text color?", new String[]{"font-color", "color", "text-color", "foreground"}, 1));
            list.add(new Question("In Python, which loop is used when the number of iterations is known?", new String[]{"while", "for", "do-while", "repeat"}, 1));
            list.add(new Question("What does JVM stand for in Java?", new String[]{"Java Visual Machine", "Java Virtual Machine", "Java Verified Machine", "Java Variable Machine"}, 1));
            list.add(new Question("How do you create a tuple in Python?", new String[]{"[]", "{}", "()", "<>"}, 2));
            list.add(new Question("Which keyword is used to inherit a class in Java?", new String[]{"implements", "extends", "inherits", "super"}, 1));
            list.add(new Question("What does SQL stand for?", new String[]{"Structured Query Language", "Simple Query Language", "System Query Language", "Standard Query Language"}, 0));
            list.add(new Question("Which is faster for insertions: ArrayList or LinkedList?", new String[]{"ArrayList", "LinkedList", "Both same", "Depends"}, 1));
            list.add(new Question("In Python, what is used to define a function?", new String[]{"func", "define", "def", "function"}, 2));
            list.add(new Question("Which attribute is used for inline styles in HTML?", new String[]{"class", "id", "style", "font"}, 2));
        }
        else if (level.equals("challenge")) {
            list.add(new Question("What is the worst-case time complexity of quicksort?", new String[]{"O(n)", "O(n log n)", "O(n²)", "O(log n)"}, 2));
            list.add(new Question("Which design pattern is used to create objects without specifying the exact class?", new String[]{"Singleton", "Factory", "Observer", "Decorator"}, 1));
            list.add(new Question("In Java, what is 'new String(\"hello\") == \"hello\"'?", new String[]{"true", "false", "compilation error", "runtime error"}, 1));
            list.add(new Question("What is the space complexity of merge sort?", new String[]{"O(1)", "O(log n)", "O(n)", "O(n log n)"}, 2));
            list.add(new Question("In Python 3.9+, which decorator is used for memoization?", new String[]{"@cache", "@memo", "@lru_cache", "@remember"}, 0));
            list.add(new Question("What is the difference between == and .equals() in Java?", new String[]{"Same", "== checks reference, equals checks value", "equals checks reference", "No difference"}, 1));
            list.add(new Question("Which algorithm is used in Java's Arrays.sort() for primitives?", new String[]{"Bubble", "Merge", "Quick", "Dual-Pivot Quick"}, 3));
            list.add(new Question("What does GIL stand for in Python?", new String[]{"Global Interpreter Lock", "General Instruction List", "Global Import Lock", "General Interface Lock"}, 0));
            list.add(new Question("What is the time complexity of binary search?", new String[]{"O(n)", "O(log n)", "O(1)", "O(n²)"}, 1));
            list.add(new Question("Which HTTP method is both idempotent and safe?", new String[]{"POST", "PUT", "DELETE", "GET"}, 3));
            list.add(new Question("In Java, what is a record (introduced in Java 16)?", new String[]{"Immutable data class", "Mutable class", "Interface", "Abstract class"}, 0));
            list.add(new Question("Which data structure is best for LRU Cache?", new String[]{"Queue", "Stack", "HashMap + Doubly Linked List", "TreeMap"}, 2));
            list.add(new Question("What does REST stand for in API design?", new String[]{"Representational State Transfer", "Rapid Execution State Transfer", "Real-time State Transfer", "Reliable Service Transfer"}, 0));
            list.add(new Question("Which is the most used JavaScript framework in 2026?", new String[]{"React", "Vue", "Angular", "Svelte"}, 0));
            list.add(new Question("What is Big O notation for accessing an element in an array?", new String[]{"O(n)", "O(log n)", "O(1)", "O(n²)"}, 2));
        }

        return list;
    }
}

class Question {
    String questionText;
    String[] options;
    int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}