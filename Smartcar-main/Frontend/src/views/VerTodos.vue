<template>
  <ion-page style="background-color: white;">
    <Toolbar value="Todos los vehículos" atras="true" refAtras="./inicio"></Toolbar>
    <ion-content :fullscreen="true" class="ion-padding ion-text-center">
      <ion-modal :is-open="modalIsOpen" @didDismiss="modalIsOpen = false" :css-class="['my-custom-modal']">
        <ModalToolbar value="Datos del vehículo" @click="closeModal"></ModalToolbar>
        <ion-content class="ion-padding">
          <DatosVehiculo :vehiculo="vehiculoData"></DatosVehiculo>
          <Button id="comprar" value="Comprar"></Button>
        </ion-content>
      </ion-modal>
      <ion-card v-for="(vehiculo, index) in items" :key="index">
        <ion-card-header>
          <ion-card-title>{{ vehiculo.nombre }}</ion-card-title>
        </ion-card-header>
        <ion-card-content>
          <ResumenVehiculo :vehiculo="vehiculo"></ResumenVehiculo>
          <Button id="ver-mas" value="Ver más..." nameMethod="fetchRecordById"
            @click="fetchRecordById(vehiculo.id)"></Button>
        </ion-card-content>
      </ion-card>
    </ion-content>
  </ion-page>

</template>

<script setup lang="ts">
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar, IonModal, IonCard, IonCardContent, IonCardHeader, IonCardSubtitle, IonCardTitle, IonButton } from '@ionic/vue';
import * as IonIcons from 'ionicons/icons';
import Button from '@/components/Button.vue';
import Toolbar from '@/components/Toolbar.vue';
import BusquedaInput from '@/components/BusquedaInput.vue';
import ResumenVehiculo from '@/components/ResumenVehiculo.vue';
import DatosVehiculo from '@/components/DatosVehiculo.vue';
import ModalToolbar from '@/components/ModalToolbar.vue';
import axios from 'axios';
import { onMounted, ref } from 'vue';

// Rutas de la API
const baseURL = 'http://localhost:8080/smartcar/vehiculo';


const modal1IsOpen = ref(false);
const modalIsOpen = ref(false);
const items = ref<Array<ItemType>>([]);

let vehiculoData: Array<ItemType>;
let vehiculos: Array<ItemType>;

onMounted(() => {
  findAllRecords();
});

// Tipos
interface ItemType {
  id: string,
  nombre: string,
  marca: string,
  descripcion: string,
  modelo: string,
  ubicacion: string,
  anio: string,
  condicion: string,
  transmision: string,
  tipo: string,
  combustible: string,
  ultimoDigito: string,
  precio: string,
  kilometraje: string,
  imagen: string,
}

// Obtener todos los registros
async function findAllRecords() {
  try {
    const response = await axios.get(baseURL);
    items.value = response.data;
    vehiculos = items.value;
    return response.data;
  } catch (error) {
    console.error('Error al obtener todos los registros:', error);
    throw error;
  }
}

// Obtener por ID
async function fetchRecordById(recordId: string) {
  openModalAdd();
  vehiculos.forEach(element => {
    if (element.id == recordId) {
      vehiculoData = element
    }
  })

}

const openModalAdd = () => {
  modalIsOpen.value = true;
};

const closeModal = () => {
  modalIsOpen.value = false;
};


</script>