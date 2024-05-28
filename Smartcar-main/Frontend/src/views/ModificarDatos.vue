<template>
    <ion-page style="background-color: white;">
        <Toolbar value="Búsqueda para modificar datos" atras="true" refAtras="./admin/inicio"></Toolbar>
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
                            <Button id="modificar" value="Modificar" nameMethod="fetchVehiculoById" color="warning"
                                @click="fetchVehiculoById(vehiculo.id, 2)"></Button>
                            <Button id="eliminar" value="Eliminar" nameMethod="fetchVehiculoById" color="danger"
                                @click="fetchVehiculoById(vehiculo.id, 3)"></Button>
                        </ion-card-content>
                    </ion-card>
                </ion-content>
            </ion-modal>
            <ion-modal :is-open="modal2IsOpen" @didDismiss="modal2IsOpen = false" :css-class="['my-custom-modal']">
                <ModalToolbar value="Modificación de los datos del vehículo" @click="closeModal2"></ModalToolbar>
                <ion-content class="ion-padding">
                    <VehiculoInput :vehiculo="vehiculoData"></VehiculoInput>
                    <Button id="modificar" value="Modificar" nameMethod="updateVehiculo" color="warning"
                        @click="updateVehiculo(vehiculoData.id)"></Button>
                </ion-content>
            </ion-modal>
            <ion-modal :is-open="modal3IsOpen" @didDismiss="modal3IsOpen = false" :css-class="['my-custom-modal']">
                <ModalToolbar value="Confirmación para eliminar vehículo" @click="closeModal3"></ModalToolbar>
                <ion-content class="ion-padding">
                    <DatosVehiculo :vehiculo="vehiculoData"></DatosVehiculo>
                    <Button id="eliminar" value="Eliminar" nameMethod="deleteVehiculo" color="danger"
                        @click="deleteVehiculo(vehiculoData.id)"></Button>
                </ion-content>
            </ion-modal>
            <!-- Búsqueda -->
            <BusquedaInput></BusquedaInput>
            <Button id="find" value="Buscar" nameMethod="findSelectedVehiculos"
                @click="findSelectedVehiculos(mostrar)"></Button>
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
import VehiculoInput from '@/components/VehiculoInput.vue';
import ModalToolbar from '@/components/ModalToolbar.vue';
import axios from 'axios';
import { onMounted, ref } from 'vue';

// Rutas de la API
const baseURLVehiculo = 'http://localhost:8080/smartcar/vehiculo';
const baseURLAdmin = 'http://localhost:8080/smartcar/administrador';


const modal1IsOpen = ref(false);
const modal2IsOpen = ref(false);
const modal3IsOpen = ref(false);
const itemsVehiculo = ref<Array<ItemTypeVehiculo>>([]);
const itemsAdmin = ref<Array<ItemTypeAdmin>>([]);
const mostrar = "mostrar";

let vehiculoData: Array<ItemTypeVehiculo>;
let vehiculos: Array<ItemTypeVehiculo>;
let vehiculosSelect: Array<ItemTypeVehiculo>;
let admins: Array<ItemTypeAdmin>;
let administradorRegistroID: String;

onMounted(() => {
    findAllVehiculos();
    findAdminReg();
});

// Tipos
interface ItemTypeVehiculo {
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

async function findAdminReg() {
    try {
        // Obtener todos los registros
        const response = await axios.get(baseURLAdmin);
        itemsAdmin.value = response.data;

        // Obtener id de referencia
        getAdminReg();
    } catch (error) {
        console.error('Error al obtener todos los registros:', error);
        throw error;
    }
}

// Obtener el número de id del administrador de registro
async function getAdminReg() {
    admins = itemsAdmin.value;
    admins.forEach(element => {
        if (element.usuario === admins[0].usuario) {
            administradorRegistroID = element.id;
        }
    });
}


// Obtener todos los registros
async function findAllVehiculos() {
    try {
        const response = await axios.get(baseURLVehiculo);
        itemsVehiculo.value = response.data;
        vehiculos = itemsVehiculo.value;

        return response.data;
    } catch (error) {
        console.error('Error al obtener todos los registros:', error);
        throw error;
    }
}

// Obtener los registros que cumplen con los parametros definidos
async function findSelectedVehiculos(modo: string) {
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
    if (modo == "mostrar") {
        openModal1Add();
    }

}

// Obtener por ID
async function fetchVehiculoById(VehiculoId: string, accion: string) {
    if (accion == 2) {
        openModal2Add();
    } else if (accion == 3) {
        openModal3Add();
    }
    vehiculos.forEach(element => {
        if (element.id == VehiculoId) {
            vehiculoData = element;
        }
    })
}

// Actualizar registro
async function updateVehiculo(VehiculoId: string) {
    const data = {
        id: VehiculoId,
        nombre: vehiculoData.nombre,
        marca: vehiculoData.marca,
        descripcion: vehiculoData.descripcion,
        modelo: vehiculoData.modelo,
        ubicacion: vehiculoData.ubicacion,
        anio: vehiculoData.anio,
        condicion: vehiculoData.condicion,
        transmision: vehiculoData.transmision,
        tipo: vehiculoData.tipo,
        combustible: vehiculoData.combustible,
        ultimoDigito: vehiculoData.ultimoDigito,
        precio: vehiculoData.precio,
        kilometraje: vehiculoData.kilometraje,
        imagen: vehiculoData.imagen,
        administradorRegistroID: {
            id: administradorRegistroID
        }
    };
    try {
        const response = await axios.put(`${baseURLVehiculo}/${VehiculoId}`, data);
    } catch (error) {
        console.error('Error al actualizar el registro:', error);
        throw error;
    }
    await findAllVehiculos();
    await closeModal2();
    await findSelectedVehiculos("modificar");
    await openModal1Add();

}

// Eliminar registro
async function deleteVehiculo(idVehiculo: string) {
    try {
        const response = await axios.delete(`${baseURLVehiculo}/${idVehiculo}`);
        await findAllVehiculos();
        await closeModal3();
        await findSelectedVehiculos("modificar");
        await openModal1Add();
        return response.data;
    } catch (error) {
        console.error('Error al eliminar el registro:', error);
        throw error;
    }
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

const openModal3Add = () => {
    modal3IsOpen.value = true;
};

const closeModal3 = () => {
    modal3IsOpen.value = false;
};


</script>