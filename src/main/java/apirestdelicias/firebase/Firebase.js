// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyDz8GZvm_XnJk60HuK-4NYGpF-9Xohfl6E",
    authDomain: "deliciasdelatierra-649fe.firebaseapp.com",
    projectId: "deliciasdelatierra-649fe",
    storageBucket: "deliciasdelatierra-649fe.appspot.com",
    messagingSenderId: "759891118998",
    appId: "1:759891118998:web:642908f6a8175945f02bb7",
    measurementId: "G-ZMFX3ZYVK7"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);