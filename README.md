# percolation


When it rains, water soaks into the ground. When sand grains are packed tightly, water doesn't soak as far down. Your task is to write a two-dimensional model of this situation.

Construct an NxN grid, that is, a square array. Populate the grid randomly with "sand" grains, such that each location has a sand grain with probability p, or is empty with probability (1-p). You should use the Math.random() method for this – this method will return a random number between 0.0 and 1.0; think about how you can use the value of this number in order to convert it to 1 or 0 with probability p or (1-p).
"Water" arrives at the top of this array, so that every empty location in the first row becomes filled with water.
Water will only flow down or horizontally, never up. For each succeeding row, if an empty space has water directly above it, or horizontally adjacent to it, it also fills with water. At each move, water can flow any distance horizontally.
If the ground is packed tightly with sand, water will not seep very far down into it. If the ground is very loosely packed, water will almost certainly seep all the way down. For an NxN container, there is some packing probability p such that water has exactly a 50% probability of seeping all the way to the bottom row. Your job is to find that probability.
