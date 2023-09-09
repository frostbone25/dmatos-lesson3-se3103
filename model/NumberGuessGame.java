package model;

import java.util.Random;

public class NumberGuessGame 
{
    public static final int MAX_KEY = 100;

    private int key;
    private int geuss;
    private boolean showKeyOn;
    private int attempts;
    private GameState state;
    private PlayStrategy strategy;
    public String progressMessage;

    public NumberGuessGame()
    {
        key = -1;
        geuss = -1;
        showKeyOn = false;
        attempts = 0;
        state = GameState.INIT;
        strategy = PlayStrategy.HighLow;
    }

    public void start()
    {
        key = generateNewKey();
        geuss = -1;
        attempts = 0;
        progressMessage = null;
    }

    private int generateNewKey()
    {
        Random random = new Random();
        int newKey;

        do
        {
            newKey = random.nextInt(MAX_KEY + 1);
        } 
        while(newKey == key);

        return newKey;
    }

    public void play(int geuss)
    {
        ++attempts;

        if(strategy == PlayStrategy.HighLow)
        {
            playHighLow(geuss);
        }
        else if(strategy == PlayStrategy.CloserAway)
        {
            playCloserAway(geuss);
        }
    }

    private void playHighLow(int geuss)
    {
        this.geuss = geuss;

        int difference = geuss - key;
        if(difference < 0)
        {
            progressMessage = "Go Higher!";
        }
        else if(difference == 0)
        {
            progressMessage = "You got it! The key was " + key;
        }
        else
        {
            progressMessage = "Go Lower!";
        }
    }

    private void playCloserAway(int geuss)
    {
        int prevDiff = Math.abs(key - this.geuss);
        int newDiff = Math.abs(key - geuss);

        this.geuss = geuss;

        if(newDiff - prevDiff < 0)
        {
            progressMessage = "Getting closer";
        }
        else
        {
            progressMessage = "Not getting closer";
        }
    }

    public int getAttempts()
    {
        return attempts;
    }

    public void setAttempts(int attempts)
    {
        this.attempts = attempts;
    }

    public PlayStrategy getStrategy()
    {
        return strategy;
    }

    public void setStrategy(PlayStrategy strategy)
    {
        this.strategy = strategy;
    }

    public GameState getState()
    {
        return state;
    }

    public void setState(GameState state)
    {
        this.state = state;
    }

    public boolean isShowKeyOn()
    {
        return showKeyOn;
    }

    public void setShowKeyOn(boolean showKeyOn)
    {
        this.showKeyOn = showKeyOn;
    }

    public int getGuess()
    {
        return geuss;
    }

    public void setGuess(int guess)
    {
        this.geuss = guess;
    }

    public int getKey()
    {
        return key;
    }

    public void setKey(int key)
    {
        this.key = key;
    }

    @Override
    public String toString()
    {
        return String.format("key(%d) guess(%d) attempts(%d)", key, geuss, attempts);
    }
}
