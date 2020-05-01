# Data-Structures-Implementation 

These are my implementations of data structures in Java from scratch. I will do it on purpose to implement most of the same functions and features as the Java [Collections](https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html) library, but my own way. This is an ongoing project, so there is always more to come. I started it April 28th, 2020. 

Up to date implemented data structures:
* *__LinkedList__*: File: *BasicLinkedList.java*. This is a basic [LinkedList](https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html) data structure with a root node and every node has a pointer to the next node in the list. I implemented a simple one with only a reference to the root node. However, there are better more optimized ways of storing and using a linked list. More info in the first few lines of the *BasicLinkedList.java* file in the *dataStructures.linkedLists* package. Along with this data structure, I implemented a divide and conquer sorting algorithm, aka [MergeSort](https://en.wikipedia.org/wiki/Merge_sort). This is the best way to sort a linked list since [QuickSort](https://en.wikipedia.org/wiki/Quicksort) is slow due to random access' not being efficient with linked lists.

* *__ArrayList__*: File: *BasicArrayList.java*. This is a basic *dynamic* array data structure. It resembles the [ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) collection implemented in Java 2 and the [Vector](https://en.cppreference.com/w/cpp/container/vector) class in C++. The implemented search algorithm is [Binary Search](https://en.wikipedia.org/wiki/Binary_search_algorithm) and the implemented sort algorithms are [InsertionSort](https://en.wikipedia.org/wiki/Insertion_sort) for small arrays under 64 elements (because it's quicker), Quicksort for arrays between 64 and 256 in size and MergeSort for bigger arrays.

* *__Stack__*: File: *BasicStack.java*. This is Stack class. It extends the *BasicArrayList* class and adds the needed *push()*, *pop()*, and *peek()* functions. It's similar to the [Stack](https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html) class in Java collections. 

What is to come next?
* [Queues](https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html) and [Deques](https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html)
* [Binary Trees](https://www.geeksforgeeks.org/binary-tree-set-1-introduction/) and [Binary Search Trees](https://www.geeksforgeeks.org/binary-search-tree-data-structure/)
* [HashTables](https://docs.oracle.com/javase/8/docs/api/java/util/Hashtable.html) and [HashSets](https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html)
* [Graphs](https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/)
* Tries

Every sub-package has a tester class where I test every function and feature. Those classes are very messy. However, they are not meant to be neat, they are just for testing purposes. Also, every function has it's run-time and space complexity written next to the declaration.

More in depth explanations on my website shortly after every implementation. And perhaps even a YouTube video if it's really important to make one.  