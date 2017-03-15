package softwaremanagementtool.agile;

public class BacklogStats {

	private Integer[] numUserStory = new Integer[UserStory.STATE.length];
	private Integer[] userStoryPnts = new Integer[UserStory.STATE.length];
	
// TODO	private Integer[] numChangeReq = new Integer[ChangeReq.STATE.length];
//	private Integer[] changeReqPnts = new Integer[ChangeReq.STATE.length];
	
	private Integer usStateIndex(String str) {
		Integer indx;
		for (indx = 0; indx < UserStory.STATE.length; indx++ ) {
			if (str.equals(UserStory.STATE[indx])) {
				return indx;
			}
		}
		// TODO raise exception
		return 0;
	}
	
	public void setUserStoryCount(String state, Integer count) {
		numUserStory[usStateIndex(state)] = count;
	}
	public void setUserStoryPoints(String state, Integer points) {
		userStoryPnts[usStateIndex(state)] = points;
	}
	
	public Integer getUserStoryCount(String state) {
		return numUserStory[usStateIndex(state)];
	}
	public Integer getUserStoryPoints(String state) {
		return userStoryPnts[usStateIndex(state)];
	}
}
