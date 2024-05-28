<template>
    <div style="align-items: center;">
        <ion-img v-if="vehiculo.imagen" :src="`data:image/jpeg;base64,${vehiculo.imagen}`"></ion-img>
        <ion-label v-else>Imagen no disponible</ion-label><br />
        <ion-list>
            <ion-item>
                <ion-label>{{ vehiculo.descripcion }}</ion-label>
            </ion-item>
            <ion-item>
                <ion-label>Nombre: {{ vehiculo.nombre }}</ion-label>
            </ion-item>
            <ion-item>
                <ion-label>Marca: {{ vehiculo.marca }}</ion-label>
            </ion-item>
            <ion-item>
                <ion-label>modelo: {{ vehiculo.modelo }}</ion-label>
            </ion-item>
            <ion-item>
                <ion-label>Año: {{ vehiculo.anio }}</ion-label>
            </ion-item>
            <ion-item>
                <ion-label>Ubicación: {{ vehiculo.ubicacion }}</ion-label>
            </ion-item>
            <ion-item>
                <ion-label>Condición: {{ vehiculo.condicion }}</ion-label>
            </ion-item>
            <ion-item>
                <ion-label>Transmisión: {{ vehiculo.transmision }}</ion-label>
            </ion-item>
            <ion-item>
                <ion-label>Tipo: {{ vehiculo.tipo }}</ion-label>
            </ion-item>
            <ion-item>
                <ion-label>Combustible: {{ vehiculo.combustible }}</ion-label>
            </ion-item>
            <ion-item>
                <ion-label>Último dígito de placa: {{ vehiculo.ultimoDigito }}</ion-label>
            </ion-item>
            <ion-item>
                <ion-label>Precio: {{ vehiculo.precio }}</ion-label>
            </ion-item>
            <ion-item>
                <ion-label>Kilometraje: {{ vehiculo.kilometraje }}</ion-label>
            </ion-item>
        </ion-list>
    </div>
</template>

<script setup lang="ts">
import { IonLabel, IonImg } from '@ionic/vue';
import { defineProps } from 'vue';

const props = defineProps(['vehiculo']);
</script>