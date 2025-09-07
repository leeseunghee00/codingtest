import java.util.*;

class Solution {
    
    private static final int LAST_TIME = 23 * 60 + 59;

    public int[] solution(int[] fees, String[] records) {
        
        Map<String, List<Parking>> cars = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (String r : records) {
            String[] record = r.split(" ");
            
            int time = changeByMinute(record[0]);
            String car = record[1];
            String log = record[2];
            
            cars.computeIfAbsent(car, k -> new ArrayList<>())
                .add(new Parking(time, log));
        }
        
        List<String> carNums = new ArrayList<>(cars.keySet());
        Collections.sort(carNums);
        
        for (String car : carNums) {
            int fee = calculate(fees, cars.get(car));
            result.add(fee);
        }
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    private int calculate(int[] fees, List<Parking> parkings) {
        parkings.sort(Comparator.comparingInt(p -> p.time));
        
        int totalMinutes = 0;
        int lastIn = -1;
        
        for (Parking p : parkings) {
            if ("IN".equals(p.log)) {
                lastIn = p.time;
            } else if ("OUT".equals(p.log) && lastIn != -1) {
                totalMinutes += (p.time - lastIn);
                lastIn = -1;
            }
        }
        
        if (lastIn != -1) {
            totalMinutes += (LAST_TIME - lastIn);
        }
        
        // 기본 요금
        if (totalMinutes <= fees[0]) {
            return fees[1];
        }
        
        int over = totalMinutes - fees[0];
        int units = (over + fees[2] - 1) / fees[2];
        
        return fees[1] + units * fees[3];
    }
        
    private int changeByMinute(String time) {
        String[] times = time.split(":");

        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
    
    class Parking {
        int time;
        String log;
        
        Parking(int time, String log) {
            this.time = time;
            this.log = log;
        }
    }
}
