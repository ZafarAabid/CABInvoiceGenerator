package fairGenerator;

public class Subscription {
    public static  Double MINIMUM_DISTANCE_PER_KILOMETER = 00.0;
    public static  Double COST_PER_TIME = 0.0;
    public static  double MINIMUM_FARE = 0.0;

    public enum Subscribe{
        NORMAL{
            public Subscription subscribe(){
                    Subscription subscription = new Subscription();
                    subscription.MINIMUM_DISTANCE_PER_KILOMETER = 10.0;
                    subscription.COST_PER_TIME = 1.0;
                subscription.MINIMUM_FARE = 5.0;
                return  subscription;
            }
        },PREMIUM{
            public Subscription subscribe(){
                Subscription subscription = new Subscription();
                subscription.MINIMUM_DISTANCE_PER_KILOMETER = 15.0;
                subscription.COST_PER_TIME = 2.0;
                subscription.MINIMUM_FARE = 20.0;
                return  subscription;
            }
        };
        public Subscription subscribe(){ return null; }
    }

    public static Subscription subscribe(Subscribe parameter) {
        return parameter.subscribe();
    }
}
