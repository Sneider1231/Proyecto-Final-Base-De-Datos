<template>
  <ion-page style="background-color: white;">
    <Toolbar value="Agregar Vehículo" atras="true" refAtras="./admin/inicio"></Toolbar>
    <ion-content :fullscreen="true" class="ion-padding ion-text-center">
      <!-- Campos -->
      <VehiculoInput :vehiculo="vehiculo"></VehiculoInput>
      <Button id="created" value="Agregar" nameMethod="createRecord" @click="createRecord"></Button>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonHeader, IonContent, IonPage } from '@ionic/vue';
import Button from '@/components/Button.vue';
import Toolbar from '@/components/Toolbar.vue';
import VehiculoInput from '@/components/VehiculoInput.vue';
import axios from 'axios';
import { onMounted, ref } from 'vue';

// Rutas de la API
const baseURLVehiculo = 'http://localhost:8080/smartcar/vehiculo';
const baseURLAdmin = 'http://localhost:8080/smartcar/administrador';

const items = ref<Array<ItemTypeAdmin>>([]);
const vehiculo = ref('')

let admins: Array<ItemTypeAdmin>;
let administradorRegistroID: String;

// Tipos de la clase administrador
interface ItemTypeAdmin {
  id: string;
  usuario: string;
  contrasenia: string;
}

onMounted(() => {
  findAdminReg();
});

async function findAdminReg() {
  try {
    // Obtener todos los registros
    const response = await axios.get(baseURLAdmin);
    items.value = response.data;

    // Obtener id de referencia
    getAdminReg();
  } catch (error) {
    console.error('Error al obtener todos los registros:', error);
    throw error;
  }
}

// Obtener el número de id del administrador de registro
async function getAdminReg() {
  admins = items.value;
  admins.forEach(element => {
    if (element.usuario === admins[0].usuario) {
      administradorRegistroID = element.id;
    }
  });
}

async function verImagen() {
  // Agrega tu lógica para mostrar o examinar la imagen aquí
}

async function createRecord() {
  const data = {
    nombre: nombre.value,
    marca: marca.value,
    descripcion: descripcion.value,
    modelo: modelo.value,
    ubicacion: ubicacion.value,
    anio: anio.value,
    condicion: condicion.value,
    transmision: transmision.value,
    tipo: tipo.value,
    combustible: combustible.value,
    ultimoDigito: ultimoDigito.value,
    precio: precio.value,
    kilometraje: kilometraje.value,
    imagen: imagen.value,
    administradorRegistroID: {
      id: administradorRegistroID
    }
  };

  try {
    const response = await axios.post(baseURLVehiculo, data);
    console.log('Registro creado exitosamente:', response.data);
  } catch (error) {
    console.error('Error al crear el registro:', error);
  }
}
</script>
