# Bhavanvir Rai
#### SENG 275 Assignment 1c

Q1) 

    Boundary 1: all values of x, y and z must be positive
    Boundary 2: all values of x, y and z must not be equal to zero
    Boundary 3: all values of x, y, and z must be the same
    
Q2)

    On-point: half
    Off-point: half - 1
    In-points: 0 ≤ i ≤ half - 1
    Out-points: i ≥ half
    
Q3)

Condition: if the number of legs is an even number

    On-point: 0
    Off-point: 1
    In-points: numberOfLegs = 2k, with k∈Z
    Out-points: numberOfLegs = 2k - 1, with k∈Z

Condition: it has a tail

    On-point: hasTail
    Off-point: !hasTail
    In-points: hasTail
    Out-points: !hasTail

Condition: the number of lives left is between [1, 9] inclusive

    On-point: 1
    Off-point: 0
    In-points: 1 ≤ numberOfLives ≤ 9
    Out-points: numberOfLives < 1 and numberofLives > 9
    
Condition: it has sharp nails

    On-point: hasSharpNails
    Off-point: !hasSharpNails
    In-points: hasSharpNails
    Out-points: !hasSharpNails

Condition: the sound it produces is "miauw"

    Let sound = "miauw"
    
    On-point: sound
    Off-point: !sound
    In-points: sound
    Out-points: !sound