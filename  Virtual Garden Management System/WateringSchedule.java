public class WateringSchedule {
    private Plant plant;
    private int daysSinceLastWatered;

    public WateringSchedule(Plant plant) {
        this.plant = plant;
        this.daysSinceLastWatered = 0;
    }

    public void updateWateringSchedule() {
        daysSinceLastWatered++;
        if (daysSinceLastWatered >= 3) {
            plant.setNeedsWater(true);
        }
    }

    public boolean isTimeToWater() {
        return plant.needsWater();
    }

    public void resetWateringSchedule() {
        daysSinceLastWatered = 0;
        plant.setNeedsWater(false);
    }
}
