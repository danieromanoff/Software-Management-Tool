package softwaremanagementtool.agile;

import javax.xml.bind.annotation.XmlElement;

public class BacklogStats {
	
	@XmlElement
	private Stats[] numUserStory = new Stats[BacklogEntry.STATE.length];
	@XmlElement
	private Stats[] userStoryPnts = new Stats[BacklogEntry.STATE.length];
	@XmlElement
	private Stats[] numChangeReq = new Stats[BacklogEntry.STATE.length];
	@XmlElement
	private Stats[] changeReqPnts = new Stats[BacklogEntry.STATE.length];
	
	public BacklogStats() {
		for (int i=0; i<BacklogEntry.STATE.length; i++) {
			numUserStory[i] = new Stats();
			numUserStory[i].setState(BacklogEntry.STATE[i]);
			userStoryPnts[i] = new Stats();
			userStoryPnts[i].setState(BacklogEntry.STATE[i]);
			numChangeReq[i] = new Stats();
			numChangeReq[i].setState(BacklogEntry.STATE[i]);
			changeReqPnts[i] = new Stats();
			changeReqPnts[i].setState(BacklogEntry.STATE[i]);
		}
	}
	
	private Integer stateIndex(String str) {
		Integer indx;
		for (indx = 0; indx < BacklogEntry.STATE.length; indx++ ) {
			if (str.equals(BacklogEntry.STATE[indx])) {
				return indx;
			}
		}
		// TODO raise exception
		return 0;
	}
	
	public void clear() {
		for (int indx = 0; indx < BacklogEntry.STATE.length; indx++ ) {
			numUserStory[indx].setVal(0); 
			userStoryPnts[indx].setVal(0);
			numChangeReq[indx].setVal(0);
			changeReqPnts[indx].setVal(0);
		}
	}
	
	public void addUserStoryCount(String state, Integer count) {
		numUserStory[stateIndex(state)].setVal(
		  numUserStory[stateIndex(state)].getVal() + count);
	}
	public void addUserStoryPoints(String state, Integer points) {
		userStoryPnts[stateIndex(state)].setVal(
		  userStoryPnts[stateIndex(state)].getVal() + points);
	}
	
	public void setUserStoryCount(String state, Integer count) {
		numUserStory[stateIndex(state)].setVal(count);
	}
	public void setUserStoryPoints(String state, Integer points) {
		userStoryPnts[stateIndex(state)].setVal(points);
	}
	
	public Integer getUserStoryCount(String state) {
		return numUserStory[stateIndex(state)].getVal();
	}
	public Integer getUserStoryPoints(String state) {
		return userStoryPnts[stateIndex(state)].getVal();
	}
	
	public void addChangeReqCount(String state, Integer count) {
		numChangeReq[stateIndex(state)].setVal(
				numChangeReq[stateIndex(state)].getVal() + count);
	}
	public void addChangeReqPoints(String state, Integer points) {
		changeReqPnts[stateIndex(state)].setVal(
				changeReqPnts[stateIndex(state)].getVal() + points);
	}
	
	public void setChangeReqCount(String state, Integer count) {
		numChangeReq[stateIndex(state)].setVal(count);
	}
	public void setChangeReqPoints(String state, Integer points) {
		changeReqPnts[stateIndex(state)].setVal(points);
	}
	
	public Integer getChangeReqCount(String state) {
		return numChangeReq[stateIndex(state)].getVal();
	}
	public Integer getChangeReqPoints(String state) {
		return changeReqPnts[stateIndex(state)].getVal();
	}
	
	public Integer getTotalBacklogCount() {
		return (getUserStoryCount(BacklogEntry.STATE_OPEN) +
				getChangeReqCount(BacklogEntry.STATE_OPEN) +
				getUserStoryCount(BacklogEntry.STATE_CLOSED) +
				getChangeReqCount(BacklogEntry.STATE_CLOSED) +
				getUserStoryCount(BacklogEntry.STATE_ASSIGNED) +
				getChangeReqCount(BacklogEntry.STATE_ASSIGNED));
	}
	public Integer getTotalBacklogPoints() {
		return (getUserStoryPoints(BacklogEntry.STATE_OPEN) +
				getChangeReqPoints(BacklogEntry.STATE_OPEN) +
				getUserStoryPoints(BacklogEntry.STATE_CLOSED) +
				getChangeReqPoints(BacklogEntry.STATE_CLOSED) +
				getUserStoryPoints(BacklogEntry.STATE_ASSIGNED) +
				getChangeReqPoints(BacklogEntry.STATE_ASSIGNED));
	}
	
	public Integer getBacklogCount() {
		return (getUserStoryCount(BacklogEntry.STATE_OPEN) +
				getChangeReqCount(BacklogEntry.STATE_OPEN) +
				getUserStoryCount(BacklogEntry.STATE_ASSIGNED) +
				getChangeReqCount(BacklogEntry.STATE_ASSIGNED));
	}
	public Integer getBacklogPoints() {
		return (getUserStoryPoints(BacklogEntry.STATE_OPEN) +
				getChangeReqPoints(BacklogEntry.STATE_OPEN) +
				getUserStoryPoints(BacklogEntry.STATE_ASSIGNED) +
				getChangeReqPoints(BacklogEntry.STATE_ASSIGNED));
	}
	
	public Integer getBacklogCompleteCount() {
		return (getUserStoryCount(BacklogEntry.STATE_CLOSED) +
				getChangeReqCount(BacklogEntry.STATE_CLOSED));
	}
	public Integer getBacklogCompletePoints() {
		return (getUserStoryPoints(BacklogEntry.STATE_CLOSED) +
				getChangeReqPoints(BacklogEntry.STATE_CLOSED));
	}
	
}
