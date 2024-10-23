<template>

    <v-card outlined>
        <v-card-title>
            ProductDetail
        </v-card-title>

        <v-card-text>
            <Number label="CompanyId" v-model="value.companyId" :editMode="editMode"/>
            <Number label="ProductSize" v-model="value.productSize" :editMode="editMode"/>
            <String label="OriginalCompany" v-model="value.originalCompany" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'ProductDetail',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
        }),
        async created() {
            if(!Object.values(this.value)[0]) {
                this.$emit('input', {});
                this.newValue = {
                    'companyId': '',
                    'productSize': '',
                    'originalCompany': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('companyId' in this.value)) {
                    this.value.companyId = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('productSize' in this.value)) {
                    this.value.productSize = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('originalCompany' in this.value)) {
                    this.value.originalCompany = '';
                }
            }
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },

        methods: {
            edit() {
                this.editMode = true;
            },
            async add() {
                this.editMode = false;
                this.$emit('input', this.value);

                if(this.isNew){
                    this.$emit('add', this.value);
                } else {
                    this.$emit('edit', this.value);
                }
            },
            async remove(){
                this.editMode = false;
                this.isDeleted = true;

                this.$emit('input', this.value);
                this.$emit('delete', this.value);
            },
            change(){
                this.$emit('change', this.value);
            },
        }
    }
</script>

