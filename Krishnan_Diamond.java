/***************************************************************
* file: Krishnan_Diamond.java
* author: Kimberlyn Krishnan
* class: CS 141 – Programming and Problem Solving
*
* assignment: program 4
* date last modified: 5/12/2016
*
* purpose: this program creates the methods in which to value
* the diamonds called and sorted  by DiamondTester.java
*
****************************************************************/
public class Krishnan_Diamond implements Comparable<Krishnan_Diamond> {

public String stockNumber; //contains the identifying string of the diamond.
public double carot; //contains a double for the size of the diamond.
public String clarity; //contains a string with the clarity grade of the diamond.
public char color; //contains a char with the color grade of the diamond.
public String cut; //contains a string with the name of the diamond's cut.

private static int clarity1Index;
private static int clarity2Index;
private static int color1Index;
private static int color2Index;
private static int status;

String[] clarityArray =  { "FL", "IF", "VVS1", "VVS2", "VS1", "VS2", "SI1", "SI2" , "I1", "I2", "I3"};
char[] colorArray = {'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                       'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

// method: Krishnan_Diamond constructor
// purpose: to accept Krishnan_Diamond objects and separate its parts
Krishnan_Diamond (String sn, double ca, String cl, char co, String cu) {

stockNumber = sn;
carot = ca;
clarity = cl;
color = co;
cut = cu;

}

// method: getStock
// purpose: to return stock number
public String getStock() {
return stockNumber;
}
// method: getCarot
// purpose: to return carot value
public double getCarot() {
return carot;
}
// method: getClarity
// purpose: to return clarity value
public String getClarity() {
return clarity;
}
// method: getColor
// purpose: to return color value
public char getColor() {
return color;
}
// method: getCut
// purpose: to return cut of diamond
public String getCut() {
return cut;
}
// method: toString
// purpose: to return description of diamond
public String toString() {
String description = ("The stock number is: " + stockNumber +
                   "\nThe carot is: " + carot +
                   "\nThe clarity is: " + clarity +
                   "\nThe color is: " + color +
                   "\nThe cut is: " + cut + "\n");
return description;
}
// method: compareTo
// purpose: to compare diamonds and order them from best to worst
public int compareTo(Krishnan_Diamond other) {

if (this.getCarot() > other.getCarot())
{
  status = -1;
  return status;
}

if (this.getCarot() < other.getCarot())
{
  status = 1;
  return status;
}

if (this.getCarot() == other.getCarot())
{

  for (int i = 0; i < clarityArray.length; i++)
  {
  if ( clarityArray[i] == this.getClarity() )
  clarity1Index = i;
  }

  for (int p = 0; p < clarityArray.length; p++)
  {
  if ( clarityArray[p] == other.getClarity() )
  clarity2Index = p;
  }

  for (int k = 0; k < colorArray.length; k++)
  {
  if ( colorArray[k] == this.getColor() )
  color1Index = k;
  }

  for (int r = 0; r < colorArray.length; r++)
  {
  if ( colorArray[r] == other.getColor() )
  color2Index = r;
  }

  if ( (clarity1Index < clarity2Index) || (clarity1Index < (color2Index + 2)))
  status = -1;

  else if ( (clarity1Index > clarity2Index) || (clarity1Index > (color2Index + 2)))
  status = 1;

  else if ( (color1Index + 2 < color2Index + 2) || (color1Index + 2 < clarity2Index))
  status = -1;

  else if ( (color1Index + 2 > color2Index + 2) || (color1Index + 2 > clarity2Index))
  status = 1;

  } else {
  status =  0; // end of if statement
}

return status;
} //end of method


// end class
}
