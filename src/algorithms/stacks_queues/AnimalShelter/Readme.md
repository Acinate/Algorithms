# Animal Shelter

An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis. People must
adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether they
would prefer a dog or a cat (and will recieve the oldest animal of that type). They cannot select which specific
animal they would like. Create the data structure to maintain this system and implement operations such as enqueue
, dequeueAny, dequeueDog and dequeueCat. You may use the built-in LinkedList data structure.

## Solution

We could explore a variety of solutions to this problem. For instance, we could maintain a single queue. This would
make dequeueAny easy, but dequeueDog and dequeueCat would require iteration through the queue to find the first dog
or cat. This would increase the complexity of the solution and decrease the efficiency.

An alternative approach that is simple, clean and efficient is to simply use seperate queues for dogs and cats, and
to place them within a wrapper class called AnimalQueue. We then store some sort of timestamp to mark when each
animal was enqueued. When we call dequeueAny, we peek at the heads of both the dog and cat queue and return the
oldest.

It is important that Dog and Cat both inherit from Animal class since dequeueAny() needs to be able to support
returning both Dog and Cat objects.
 
If we wanted, order could be a true timestamp with the actual date and time. The advantage of this is that we wouldn
't have to set and maintain the numerical order. If we somehow wound up with two animals with the same timestamp
, then (by definition) we don't have an older animal and we could return either one.

 