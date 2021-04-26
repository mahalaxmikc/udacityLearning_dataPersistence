package com.udacity.course3.data;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Delivery {

        @Id
        @GeneratedValue
        private long id;

        @Nationalized
        private String recipientName;
        @Column(name = "address_full",length = 500)
        private String address;
        private LocalDateTime deliveryTime;
        @Type(type = "yes_no")
        private Boolean completed;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery", cascade = CascadeType.ALL)
        private List<Plant> plantList;



        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getRecipientName() {
                return recipientName;
        }

        public void setRecipientName(String recipientName) {
                this.recipientName = recipientName;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public LocalDateTime getDeliveryTime() {
                return deliveryTime;
        }

        public void setDeliveryTime(LocalDateTime deliveryTime) {
                this.deliveryTime = deliveryTime;
        }

        public Boolean getCompleted() {
                return completed;
        }

        public void setCompleted(Boolean completed) {
                this.completed = completed;
        }

        public List<Plant> getPlantList() {
                return plantList;
        }

        public void setPlantList(List<Plant> plantList) {
                this.plantList = plantList;
        }
}
