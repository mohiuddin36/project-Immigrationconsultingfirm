package com.example.immigrationconsultingfirm_project_cse213.model;

    public abstract class User {
        protected String userId;
        protected String name;
        protected String email;
        protected String password;

        public User(String userId, String name, String email, String password) {
            this.userId = userId;
            this.name = name;
            this.email = email;
            this.password = password;
        }


        public String getUserId() {
            return userId;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userId='" + userId + '\'' +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

        // Abstract method to be implemented by subclasses
        public abstract void login();



    }


