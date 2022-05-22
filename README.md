# Final Project
### CS 140: Mechanics

Instructor : Suren Khachatryan

Student: Aleksandr Aghajanyan

## Project Objective

The project aims at design and simulation of a mechanical converter that converts
binary representation of a number into its value in the decimal numeral system. The input
consists of 8 signals representing bits – 1 if a signal is recorded, and 0 – if the signal is missing.
The device generates a spring oscillation the frequency of which corresponds to the magnitude
of the recorded input.

### Task 1: 

[Check implementation here!](https://github.com/AlexAghajanyan/CS140-Project/blob/main/src/Spring.java)

Write a class Spring that implements the concept of a 1D massless spring and, hence,
encapsulates its stiffness double k with the default value equal 1.

### Task 2:

[Check implementation here!](https://github.com/AlexAghajanyan/CS140-Project/blob/main/src/SpringArray.java)

### Task 3:

Write a class FT that implements the concept of Fourier transform / series. It transforms an
array of coordinate values at different time moments into an array of the amplitudes of
harmonic oscillations. Declare member variables and implement methods as needed.

[Check implementation here!](https://github.com/AlexAghajanyan/CS140-Project/blob/main/src/FastFourierTransform.java)

#### Code Reference:

Original java complex numbers and fast fourier transform implementation source:

[https://rosettacode.org/wiki/Fast_Fourier_transform#Java](https://rosettacode.org/wiki/Fast_Fourier_transform#Java)


### Task 4:

Write a class Converter that aims at conversion of a binary representation of a single byte
into its decimal value. Consider a sequence of 8 bits and design a system of springs that
implements each of them.

[Check implementation here!](https://github.com/AlexAghajanyan/CS140-Project/blob/main/src/Converter.java)

## Book References:

An Introduction to Computer Simulation Methods Third Edition






