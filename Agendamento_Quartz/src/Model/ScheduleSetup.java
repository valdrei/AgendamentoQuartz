package Model;

public class ScheduleSetup {
	
	int secCache;
	int secCacheClear;
	
	public ScheduleSetup(int secCache, int secCacheClear){
		
		this.secCache=secCache;
		this.secCacheClear=secCacheClear;
		
	}

	public String getSecCache() {
		return "0/"+secCache+" * * * * ?";
	}

	public void setSecCache(int secCache) {
		this.secCache = secCache;
	}

	public String getSecCacheClear() {
		return "0/"+secCacheClear+" * * * * ?";
	}

	public void setSecCacheClear(int secCacheClear) {
		this.secCacheClear = secCacheClear;
	}

}
