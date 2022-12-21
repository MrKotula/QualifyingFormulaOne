package ua.foxminded.qualifyingformulaone.domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Racer {
    private final String abbreviation;
    private final String name;
    private final String teamName;
    private final LocalDateTime startTime;
    private final LocalDateTime finishTime;

    private Racer(Builder builder) {
	this.abbreviation = builder.abbreviations;
	this.name = builder.name;
	this.teamName = builder.teamName;
	this.startTime = builder.startTime;
	this.finishTime = builder.finishTime;
    }
    
    public static Builder builder() {
	return new Builder();
    }
    
    public Duration getResultRacing() {
   	return Duration.between(this.startTime, this.finishTime);
    }

    public String getName() {
	return name;
    }

    public String getTeamName() {
	return teamName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public int hashCode() {
	return Objects.hash(name, teamName, startTime, finishTime, abbreviation);
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Racer other = (Racer) obj;

	return  Objects.equals(name, other.name) && 
		Objects.equals(teamName, other.teamName) &&
		Objects.equals(startTime, other.startTime) &&
		Objects.equals(finishTime, other.finishTime) &&
		Objects.equals(abbreviation, other.abbreviation);
    }

    @Override
    public String toString() {
	return "Racer [abbreviations=" + abbreviation + '\'' + ", name=" + name + '\'' + ", teamName=" + teamName + '\'' + ", startTime="
		+ startTime + '\'' + ", finishTime=" + finishTime + '\'' + "]";
    } 
    
    public static class Builder {
	private String abbreviations;
	private String name;
	private String teamName;
	private LocalDateTime startTime;
	private LocalDateTime finishTime;
	
	private Builder() {
	}

	public Builder withStartTime (LocalDateTime startTime) {
	    this.startTime = startTime;
	    return this;
	}

	public Builder withFinishTime(LocalDateTime finishTime) {
	    this.finishTime = finishTime;
	    return this;
	}

	public Builder withAbbreviations(String abbreviations) {
	    this.abbreviations = abbreviations;
	    return this;
	}
	
	public Builder withName(String name) {
	    this.name = name;
	    return this;
	}
	
	public Builder withTeamName(String teamName) {
	    this.teamName = teamName;
	    return this;
	}

	public Racer build() {
	    return new Racer(this);
	}
    }
}
