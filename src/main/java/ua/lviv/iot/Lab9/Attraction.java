package ua.lviv.iot.Lab9;

import javax.persistence.*;

    @Entity
    @Table(name = "attraction")
    public class Attraction {

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        @Column(name = "priceOfTicket")
        private double priceOfTicket;
        @Column(name = "maxNumberOfVisitors")
        private int maxNumberOfVisitors;
        @Column(name = "dangerLevel")
        private DangerLevel dangerLevel;

        public Attraction( double priceOfTicket, int maxNumberOfVisitors, DangerLevel dangerLevel) {
            this.priceOfTicket = priceOfTicket;
            this.maxNumberOfVisitors = maxNumberOfVisitors;
            this.dangerLevel = dangerLevel;
        }

        public Attraction() {
        }

        public double getPriceOfTicket() {
            return priceOfTicket;
        }

        public void setPriceOfTicket( double priceOfTicket) {
            this.priceOfTicket = priceOfTicket;
        }

        public int getMaxNumberOfVisitors() {
            return maxNumberOfVisitors;
        }

        public void setMaxNumberOfVisitors(int maxNumberOfVisitors) {
            this.maxNumberOfVisitors = maxNumberOfVisitors;
        }

        public DangerLevel getDangerLevel() {
            return dangerLevel;
        }

        public void setDangerLevel(DangerLevel dangerLevel) {
            this.dangerLevel = dangerLevel;
        }

        @Override
        public final String toString() {
            return super.toString() + "Attraction [priceOfTicket=" + priceOfTicket + ", maxNumberOfVisitors="
                    + maxNumberOfVisitors + ", dangerlevel=" + dangerLevel + "]";
        }
    }


