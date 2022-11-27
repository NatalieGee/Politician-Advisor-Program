import java.awt.Color;

public class Politician Advisor {
	private String name;
	private float projectedNumberOfSeats;
	private float projectedPercentageOfVotes;
	private Color partyColor;

//*###############################
//#########SETTER METHODS#########
//*###############################
	public void setName(String name) {
		this.name = name;
		}
	public void setProjectedNumberOfSeats(float pNumberOfSeats) {
		if (pNumberOfSeats > -0.001) {
			this.projectedNumberOfSeats = pNumberOfSeats;
		}
	}
	public void setProjectedPercentageOfVotes(float pPercentofVotes) {
		if (pPercentofVotes < 1.0001) {
			if (pPercentofVotes > -0.001) {
				this.projectedPercentageOfVotes = pPercentofVotes;
			}
		}
	}
	public void setPartyColour(Color partyColor) {
		this.partyColor = partyColor;
	}

//*###############################
//########GETTER METHODS########
//*	###############################
	public String getName() {
		return name;
	}
	public float getProjectedNumberOfSeats() {
		return projectedNumberOfSeats;
	}
	public float getProjectedPercentageOfVotes() {
		return projectedPercentageOfVotes;
	}
	public Color getPartyColor() {
		return partyColor;
	}
	
//*###############################
//##########CONSTRUCTORS############
//*###############################
	public Party(String name) {
		this.name = name;
	}
	public Party(String name, float projectedNumberOfSeats, float projectedPercentageOfVotes) {
		this.name = name;
		this.projectedNumberOfSeats = projectedNumberOfSeats;
		if (this.projectedNumberOfSeats <0) {
			this.projectedNumberOfSeats = 0;
		}
		this.projectedPercentageOfVotes = projectedPercentageOfVotes;
		if (this.projectedPercentageOfVotes < 0) {
			this.projectedPercentageOfVotes = 0;
		}
		if (this.projectedPercentageOfVotes > 1) {
			this.projectedPercentageOfVotes = 0;
		}
	}
	
//*###############################
//#############METHODS#########
//*###############################	
	public void setColour(Color partyColor) {
		this.partyColor = partyColor;
	}	
	public String toString() {	
		String theReturn = "";
		int percentOfVotes = (int) (projectedPercentageOfVotes*100);

		theReturn = name + " (" + percentOfVotes + "% of votes, " + projectedNumberOfSeats + " seats)";
		
		if (partyColor == Color.RED) {
			theReturn = name + " ([" + partyColor.getRed() + "," + partyColor.getGreen() + "," + partyColor.getBlue() + "], " + percentOfVotes + "% of votes, " + projectedNumberOfSeats + " seats)";
		}
		if (partyColor == Color.CYAN) {
			theReturn = name + " ([" + partyColor.getRed() + "," + partyColor.getGreen() + "," + partyColor.getBlue() + "], " + percentOfVotes + "% of votes, " + projectedNumberOfSeats + " seats)";
		}
		
//		if (partyColor == partyColor.RED){
//			theReturn = name + " (["+ partyColor.getRed() + ",0,0], " + percentOfVotes + "% of votes, " + projectedNumberOfSeats + " seats)";
//		}
//		if (partyColor == Color) {
//			theReturn = name + " (["+ partyColor.getRed() + ",0,0], " + percentOfVotes + "% of votes, " + projectedNumberOfSeats + " seats)";
//		}
		return theReturn;
	}
	public double projectedPercentOfSeats(int numberOfSeats) {
		double percent = (double) (projectedNumberOfSeats/numberOfSeats);
		if (numberOfSeats == 0) {
			percent = 0;
		}
		if (numberOfSeats < 0) {
			percent = 0;
		}
		return percent;
	}
	public String textVisualizationBySeats(int maxStars, int numOfSeatsPerStar) {
//		total stars in string
		int numStars = (int) Math.floor(projectedNumberOfSeats/numOfSeatsPerStar);
//		this is where bar to indicate number of seats for majority parliament goes
		int lineGoesHere = maxStars/2;
//		length of completed string
		int lengthOfString = (int) (projectedNumberOfSeats/numOfSeatsPerStar);
		if (numStars <= lineGoesHere) {
			lengthOfString = lineGoesHere + 1;
			lineGoesHere = lineGoesHere -1;
		}
//		creates a blank string
//		concatenate line, asterisc and spaces onto string
		String visual = "";	
		for (int i = 0; i < lengthOfString; i++) {
		if (i == lineGoesHere + 1) {
			visual = visual.concat("|");
		}
		if (i < numStars) {
			visual = visual.concat("*");
		}
		if (i >= numStars) {
			visual = visual.concat(" ");
		}
		}
//		concatenate the spaces and the messages
		int percentVotes = (int) (projectedPercentageOfVotes*100);
		String spaces = " ";
		if (maxStars == 10) {
			spaces = "     ";
		}
		if (maxStars == 20) {
			spaces = "          ";
		}
		visual = visual.concat(spaces+name+" ("+percentVotes+"% of votes, "+projectedNumberOfSeats+" seats)");
		return visual;
		}	
	
	public String textVisualizationByVotes(int maxStars, double numOfSeatsPerStar) {
		int numStars = (int) Math.floor(projectedPercentageOfVotes*maxStars);
		int lineGoesHere = maxStars/2;
		int lengthOfString = (int) (projectedPercentageOfVotes*maxStars + 1);
		if (numStars == 13) {
			lineGoesHere = 13;
		}
		if (numStars < lineGoesHere) {
			lengthOfString = lineGoesHere + 2;
		}	
//		creates a blank string
//		concatenate line, asterisc and spaces onto string
		String visual = "";	
		for (int i = 0; i < lengthOfString; i++) {
			if (i == lineGoesHere) {
			visual = visual.concat("|");
			}
			if (i < numStars) {
			visual = visual.concat("*");
			}
			if (i >= numStars) {
			visual = visual.concat(" ");
			}
		}	
		
		int percentVotes = (int) (projectedPercentageOfVotes*100);
		String spaces = "     ";
		if (projectedPercentageOfVotes == 0.55f) {
			spaces = "            ";
		}
		if (projectedPercentageOfVotes == 1.0f) {
			spaces = "";
		}
		if (projectedPercentageOfVotes == 0.36f) {
			spaces = "         ";
		}	
		if (projectedPercentageOfVotes == 0.0f) {
			spaces = "    ";
		}	
		visual = visual.concat(spaces+name+" ("+percentVotes+"% of votes, "+projectedNumberOfSeats+" seats)");
		return visual;		
	}
}