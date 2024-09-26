# Read Me

HyperLogLog is a probabilistic data structure that provides an approximate count of unique items (cardinality) in a data
set with a very small memory footprint.

# From

https://blog.stackademic.com/mastering-redis-7-the-principle-and-application-scenarios-of-the-hyperloglog-data-type-c1435146fbdf
HyperLogLog’s statistical rule is based on probability and is not very accurate, with a standard error rate of 0.81%.

The advantage of HyperLogLog is that when the number or volume of input elements is very, very large, the memory space
required to calculate the cardinality is always fixed and very small.

For example, when counting the number of daily visiting IPs, you can roughly obtain the total number of IPs that visited
at that time, but you cannot know what these IPs are.

But for a large website, if there are, for example, one million visiting IPs every day, let’s assume that an IPv6
occupies 16 bytes, then one million IPs are close to 16M. If there are 10 million IPs, it is close to 160M of memory,
which is too burdensome.

For HyperLogLog, it only takes 12 KB of memory to calculate the cardinality of nearly 2^64 different elements. If it is
only used for calculating the cardinality, the consumption required is far less than that of Set.

