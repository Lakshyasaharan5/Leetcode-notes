class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        /*
            startTime = "12:34:56", endTime = "13:00:00"

            0 to 13:00:00  13*60*60
            0 to 12:34:56  12*60*60 + 34*60 + 56
                
        */

        int st = Integer.parseInt(startTime.substring(0,2)) * 60 * 60
        +
        Integer.parseInt(startTime.substring(3,5)) * 60
        +
        Integer.parseInt(startTime.substring(6,8));

        int et = Integer.parseInt(endTime.substring(0,2)) * 60 * 60
        +
        Integer.parseInt(endTime.substring(3,5)) * 60
        +
        Integer.parseInt(endTime.substring(6,8));

        return et - st;
    }
}