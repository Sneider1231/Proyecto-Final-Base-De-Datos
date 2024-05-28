<template>
  <ion-page style="background-color: white;">
    <Toolbar value="Búsqueda" atras="true" refAtras="./inicio"></Toolbar>
    <ion-content :fullscreen="true" class="ion-padding ion-text-center">
      <ion-modal :is-open="modal1IsOpen" @didDismiss="modal1IsOpen = false" :css-class="['my-custom-modal']">
        <ModalToolbar value="Resultados de búsqueda" @click="closeModal1"></ModalToolbar>
        <ion-content class="ion-padding">
          <ion-card v-for="(vehiculo, index) in vehiculosSelect" :key="index">
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
      </ion-modal>
      <ion-modal :is-open="modal2IsOpen" @didDismiss="modal2IsOpen = false" :css-class="['my-custom-modal']">
        <ModalToolbar value="Datos del vehículo" @click="closeModal2"></ModalToolbar>
        <ion-content class="ion-padding">
          <DatosVehiculo :vehiculo="vehiculoData"></DatosVehiculo>
          <Button id="comprar" value="Comprar"></Button>
        </ion-content>
      </ion-modal>
      <!-- Búsqueda -->
      <BusquedaInput></BusquedaInput>
      <Button id="find" value="Buscar" nameMethod="findSelectedRecords" @click="findSelectedRecords"></Button>
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
const modal2IsOpen = ref(false);
const items = ref<Array<ItemType>>([]);

let vehiculoData: Array<ItemType>;
let vehiculos: Array<ItemType>;
let vehiculosSelect: Array<ItemType>;

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

// Obtener los registros que cumplen con los parametros definidos
async function findSelectedRecords() {
  vehiculosSelect = [];
  vehiculos.forEach(element => {
    if ((element.nombre == nombre.value && nombre.value) ||
      (element.marca == marca.value && marca.value) ||
      (element.modelo == modelo.value && modelo.value) ||
      (element.ubicacion == ubicacion.value && ubicacion.value) ||
      (element.anio == anio.value && anio.value) ||
      (element.condicion == condicion.value && condicion.value) ||
      (element.transmision == transmision.value && transmision.value) ||
      (element.tipo == tipo.value && tipo.value) ||
      (element.combustible == combustible.value && combustible.value) ||
      (element.ultimoDigito == ultimoDigito.value && ultimoDigito.value) ||
      (element.precio <= precioMin.value && element.precio >= precioMax.value) ||
      (element.kilometraje <= kilometrajeMin.value && element.kilometraje >= kilometrajeMax.value)
    ) {
      vehiculosSelect.push(element);
    }
  });
  await openModal1Add();
}

// Obtener por ID
async function fetchRecordById(recordId: string) {
  openModal2Add();
  vehiculos.forEach(element => {
    if (element.id == recordId){
      vehiculoData=element;
    }})
    
}

const openModal1Add = () => {
  modal1IsOpen.value = true;
};

const closeModal1 = () => {
  modal1IsOpen.value = false;
};

const openModal2Add = () => {
  modal2IsOpen.value = true;
};

const closeModal2 = () => {
  modal2IsOpen.value = false;
};


</script>