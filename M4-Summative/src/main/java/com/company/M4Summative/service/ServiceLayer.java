package com.company.M4Summative.service;

import com.company.M4Summative.model.Consoles;
import com.company.M4Summative.model.Games;
import com.company.M4Summative.model.Invoice;
import com.company.M4Summative.model.TShirts;
import com.company.M4Summative.repository.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class ServiceLayer {
        TShirtsRepository tshirtRepository;
        GamesRepository gameRepository;
        ConsolesRepository consoleRepository;
        InvoiceRepository invoiceRepository;
        SalesTaxRateRepository salesTaxRateRepository;
        ProcessingFeeRepository processingFeeRepository;
        int availableAmount;
        int updatedAmount;
        @Autowired
        public ServiceLayer(GamesRepository gameRepository, ConsolesRepository consoleRepository, TShirtsRepository tshirtRepository,InvoiceRepository invoiceRepository, SalesTaxRateRepository salesTaxRateRepository,ProcessingFeeRepository processingFeeRepository) {
            this.gameRepository = gameRepository;
            this.consoleRepository = consoleRepository;
            this.tshirtRepository = tshirtRepository;
            this.invoiceRepository = invoiceRepository;
            this.salesTaxRateRepository = salesTaxRateRepository;
            this.processingFeeRepository = processingFeeRepository;
        }
        // CLEAR DATABASE
        public void clearDatabase() {
            gameRepository.deleteAll();
            tshirtRepository.deleteAll();
            consoleRepository.deleteAll();
            invoiceRepository.deleteAll();
        }
        //Jpa Searches
        public List<TShirts> getTshirtByColor(String color){return tshirtRepository.findByColor(color);}
        public List<TShirts> getTshirtBySize(String size){return tshirtRepository.findBySize(size);}

        //TShirt CRUD
        public List<TShirts> getinAllTshirt(){return tshirtRepository.findAll();}
        public Optional<TShirts> getShirtsByID(int id) {
            Optional<TShirts> tshirt = tshirtRepository.findById(id);
            return tshirt.isPresent()? Optional.of(tshirt.get()) : null;
        }
        public TShirts createShirts(@RequestBody TShirts tShirts) {
            tshirtRepository.save(tShirts);
            return tShirts;}
        public void updateTshirt(TShirts tshirt) {tshirtRepository.save(tshirt);}
        public void deleteTshirt(int id) {tshirtRepository.deleteById(id);}
        // GAME CRUD OPERATIONS
        public List<Games> gettingAllGames() {return gameRepository.findAll();}
        public List<Games> getGamesByStudio(String studio) { return gameRepository.findByStudio(studio); }
        public List<Games> findGamesByESRBRating(int esrbrating) { return gameRepository.findByESRBRating(esrbrating); }
        // public Optional<Games> findGamesByTitle(String title) { return gameRepository.findByTitle(title);}

        public Optional<Games >getsSingleGame(int id) { return gameRepository.findById(id); }
        public Games createGame(Games game) { return gameRepository.save(game); }
        public void updateGame(Games game) { gameRepository.save(game); }
        public void deleteGame(int id) { gameRepository.deleteById(id); }
        // CONSOLE CRUD
        public List<Consoles> getConsolesByManufacturer(String manufacturer) {
            return consoleRepository.findByManufacturer(manufacturer);
        }
        public List<Consoles> getAllConsoles(){
            return consoleRepository.findAll();
        }
        public Optional<Consoles>  getConsoleByID(int id) {
            return consoleRepository.findById(id);
        }
        public Consoles createConsole(Consoles console) {
            return consoleRepository.save(console);
        }
        public void updateConsole(Consoles console) {
            consoleRepository.save(console);
        }
        public void deleteConsole(int id) {
            consoleRepository.deleteById(id);
        }


        // Invoice CRUD -- Do not need to update / delete
        public List<Invoice> getAllInvoices() { return invoiceRepository.findAll(); }
        public Optional<Invoice> getInvoiceById(int id) {
            if (invoiceRepository.findById(id).orElse(null) == null) {
                return null;
            }
            return invoiceRepository.findById(id);
        }
 /*
    public Invoice addInvoice(Invoice invoice) {
        Invoice updatedInvoice = invoice;
        BigDecimal salesTax = salesTaxRateRepository.findSalesTaxByState(state);
        BigDecimal processingFee = BigDecimal.valueOf(applyProcessingFee(invoice));
        BigDecimal subtotal = BigDecimal.valueOf(calculateSubtotal(invoice));

        updatedInvoice.setTax(salesTax);
        updatedInvoice.setProcessing_fee(processingFee);
        updatedInvoice.setSubtotal(subtotal);
        updatedInvoice.setTotal(total);
        decreaseItemQuantity(updatedInvoice);
        return invoiceRepository.save(updatedInvoice);
      */
    }

