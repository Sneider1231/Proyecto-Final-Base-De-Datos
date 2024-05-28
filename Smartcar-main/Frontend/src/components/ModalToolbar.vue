<template>
  <ion-header>
    <ion-toolbar>
      <ion-title class="ion-text-center">{{ value }}</ion-title>
      <ion-buttons slot="start">
        <ion-button @click="accion">
          <ion-icon :icon="IonIcons.arrowBack"></ion-icon>
        </ion-button>
      </ion-buttons>
    </ion-toolbar>
  </ion-header>
</template>

<script setup lang="ts">
import { IonButton, IonTitle, IonButtons, IonToolbar, IonHeader, IonContent, IonPage } from '@ionic/vue';
import * as IonIcons from 'ionicons/icons';
import { defineProps } from 'vue';

const props = defineProps(['value', 'accion']);
</script>