<template>
  <ion-header>
    <ion-toolbar>
      <ion-title class="ion-text-center">{{ value }}</ion-title>
      <ion-buttons v-if="atras" slot="start">
        <ion-button :href="refAtras">
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

const props = defineProps(['value', 'atras', 'refAtras']);
</script>