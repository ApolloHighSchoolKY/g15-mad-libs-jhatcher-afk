//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MadLib
{
	private ArrayList<String> verbs = new ArrayList<String>();
	private ArrayList<String> nouns = new ArrayList<String>();
	private ArrayList<String> adjectives = new ArrayList<String>();
	private String story = "";

	public MadLib()
	{
		verbs.add("runs");
		nouns.add("Jonathan Leohr");
		adjectives.add("purple");
		story = "Jonathan Leohr run down the purple road.";
	}

	public MadLib(String fileName)
	{
		//load stuff
		loadVerbs();
		loadNouns();
		loadAdjectives();

		
		

		try
		{
			//Read the different parts of the story and concatenate the resulting
			//story using the symbols to tell you the parts of speech
			Scanner read = new Scanner(new File("story.dat"));

			//While there is more of the story, read in the word/symbol
			while (read.hasNext())
			{
				//If what was read in is one of the symbols, find a random
				//word to replace it.
				if(read.next().equals("#"))
				{
					story += getRandomNoun();
				}
				if(read.next().equals("@"))
				{
					story += getRandomVerb();
				}
				if(read.next().equals("&"))
				{
					story += getRandomAdjective();
				}
				story += read.next();
			}
				
		
			read.close();

		}
		catch(Exception e)
		{
			System.out.println("Houston we have a problem!");
		}

	}

	public void loadNouns()
	{
		Scanner readerNoun = new Scanner(new File("nouns.dat"));

		try

		
		{
			while(readerNoun.hasNext()) 
		{
			nouns.add(readerNoun.nextLine());
		}
			readerNoun.close();
		}
		catch(Exception e)
		{
			System.out.println("nouns.dat does not exist");
		}
		

	}

	public void loadVerbs()
	{
		Scanner readerVerbs = new Scanner(new File("verbs.dat"));
		try
		{
			while (readerVerbs.hasNext()) 
		{
			verbs.add(readerVerbs.nextLine());
		}
		readerVerbs.close();
		}
		catch(Exception e)
		{
			System.out.println("verbs.dat does not exist");
		}
		
	}

	public void loadAdjectives()
	{
		Scanner readerAdjective = new Scanner(new File("adjectives.dat"));

		try
		{
			while (readerAdjective.hasNext()) 
		{
			adjectives.add(readerAdjective.nextLine());
		}
		readerAdjective.close();
		}
		catch(Exception e)
		{
			System.out.println("adjectives.dat does not exist");
		}
		
	}

	public String getRandomVerb()
	{
		int x = (int)(Math.random()*(verbs.size()));
		return "" + verbs.get(x);
	}

	public String getRandomNoun()
	{
		int x = (int)(Math.random()*(nouns.size()));
		return "" + nouns.get(x);
	}

	public String getRandomAdjective()
	{
		Random rand = new Random(adjectives.size());
		int x = rand.nextInt();
		return "" + adjectives.get(x);
	}

	public String toString()
	{
		return "" ;
	}
}