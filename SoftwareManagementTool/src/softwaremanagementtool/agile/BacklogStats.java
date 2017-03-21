package softwaremanagementtool.agile;

public class BacklogStats {
	
	private Integer[] numUserStory = new Integer[BacklogEntry.STATE.length];
	private Integer[] userStoryPnts = new Integer[BacklogEntry.STATE.length];
	
	private Integer[] numChangeReq = new Integer[BacklogEntry.STATE.length];
	private Integer[] changeReqPnts = new Integer[BacklogEntry.STATE.length];
	
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
	
	}
	
	public void setUserStoryCount(String state, Integer count) {
		numUserStory[stateIndex(state)] = count;
	}
	public void setUserStoryPoints(String state, Integer points) {
		userStoryPnts[stateIndex(state)] = points;
	}
	
	public Integer getUserStoryCount(String state) {
		return numUserStory[stateIndex(state)];
	}
	public Integer getUserStoryPoints(String state) {
		return userStoryPnts[stateIndex(state)];
	}
}
