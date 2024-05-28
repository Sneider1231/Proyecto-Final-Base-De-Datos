<template>
    <div style="align-items: center;">
        <ion-img v-if="vehiculo.imagen" :src="`data:image/jpeg;base64,${vehiculo.imagen}`"></ion-img>
        <ion-label v-else>Imagen no disponible</ion-label><br />
        <ion-list>
            <ion-item>
                <ion-label>{{ vehiculo.descripcion }}</ion-label>
            </ion-item>
            <ion-item>
                <ion-label>Precio: {{ vehiculo.precio }}</ion-label>
            </ion-item>
        </ion-list>
    </div>
</template>

<script setup lang="ts">
import { IonLabel, IonImg, IonList, IonItem } from '@ionic/vue';
import { defineProps } from 'vue';


const props = defineProps(['vehiculo']);

</script>