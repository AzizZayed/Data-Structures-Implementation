# Data-Structures-Implementation 

These are my implementations of data structures in Java from scratch. I will do it on purpose to implement most of the same functions and features as the Java Collections library, but my own way. This is an ongoing project, so there is always more to come. I started it April 28th, 2020. 

Up to date implemented data structures:
* *__LinkedList__*: File: *BasicLinkedList.java*. This is a basic data structure with a root node and every node has a pointer to the next node in the list. I implemented a simple one with only a reference to the root node. However, there are better more optimized ways of storing and using a linked list. More info in the first few lines of the *BasicLinkedList.java* file in the *dataStructures.linkedLists* package. Along with this data structure, I implemented a divide and conquer sorting algorithm, aka MergeSort. This is the best way to sort a linked list since QuickSort is slow due to random access' not being efficient with linked lists.

* *__ArrayList__*: File: *BasicArrayList.java*. This is a basic *dynamic* array data structure. It resembles the ArrayList collection implemented in Java 2 and the Vector class in C++. The implemented search algorithm is binary search and the implemented sort algorithms are InsertionSort for small arrays under 64 elements (because it's quicker), Quicksort for arrays between 64 and 256 in size and MergeSort for bigger arrays.

* *__Stack__*: File: *BasicStack.java*. This is Stack class. It extends the *BasicArrayList* class and adds the needed *push()*, *pop()*, and *peek()* functions.

What is to come next?
* Queues and Deques
* Binary Trees and Binary Search Trees
* HashTables and HashSets
* Graphs
* Tries

Every sub-package has a tester class where I test every function and feature. Those classes are very messy. However, they are not meant to be neat, they are just for testing purposes. Also, every function has it's run-time and space complexity written next to the declaration.

More in depth explanations on my website shortly after every implementation. And perhaps even a YouTube video if it's really important to make one.  