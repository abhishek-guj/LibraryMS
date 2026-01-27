
using System;
using System.Collections.Generic;

public class Count
{
    public static int Id = 0;
}
public enum BookCategory
{
    Fiction, NonFiction, Historical
}
// public enum MembershipType
// {
//     Student, Regular, Premium
// }

// EXCEPTIONS
public class BookUnavailableException : System.Exception
{
    public BookUnavailableException(string message) : base(message) { }
}
public class ExceedsBorrowLimitException : System.Exception
{
    public ExceedsBorrowLimitException(string message) : base(message) { }
}
// EXCEPTIONS

public interface IBook
{
    void Borrow();
    void Return();
}

public interface IMembership
{
    public int BookLimit { get; }
    public int MaxDays { get; }
}


public abstract class Book : IBook
{
    public int Id { get; set; }
    public string Title { get; set; }
    public string Author { get; set; }
    public string ISBN { get; set; }
    public bool isAvailable { get; set; } = true;
    public BookCategory Category { get; set; }
    public int ReturnDate { get; set; }

    public Book(int id, string title, string author, string isbn, bool available, BookCategory category)
    {
        Id = id;
        Title = title;
        Author = author;
        ISBN = isbn;
        isAvailable = available;
        Category = category;
    }

    public virtual void Borrow()
    {
        if (!isAvailable)
        {
            throw new BookUnavailableException("Book is already Borrowed");
        }
        isAvailable = false;
    }
    public virtual void Return()
    {
        isAvailable = true;
    }
}

public class EBook : Book
{
    public int FileSize { get; set; }
    public EBook(int id, int size, string title, string author, string isbn, bool available, BookCategory category)
        : base(id, title, author, isbn, available, category)
    {
        FileSize = size;
    }
}
public class ShelfBook : Book
{
    public string ShelfLoc { get; set; }
    public ShelfBook(int id, string loc, string title, string author, string isbn, bool available, BookCategory category)
        : base(id, title, author, isbn, available, category)
    {
        ShelfLoc = loc;
    }
}


public class StudentMembership : IMembership
{
    public int BookLimit => 3;
    public int MaxDays => 15;
}
public class RegularMembership : IMembership
{
    public int BookLimit => 5;
    public int MaxDays => 40;
}
public class PremiumMembership : IMembership
{
    public int BookLimit => int.MaxValue;
    public int MaxDays => 45;
}



public class Member
{
    // todo: extarct interface
    public string Name { get; set; }
    public int BorrowedBooks { get; set; }
    public IMembership Membership { get; set; }
    public int BorrowedQty { get; set; } = 0;

    public void BorrowBook(Book book)
    {
        if (BorrowedBooks >= Membership.BookLimit)
        {
            throw new ExceedsBorrowLimitException("Exceeds maximum error");
        }
        book.Borrow();
        BorrowedBooks += 1;
    }

    public void ReturnBook(Book book)
    {
        book.Return();
        BorrowedBooks -= 1;
    }
}

public class Transaction
{
    // todo extrat interface
    public int TransactionId { get; set; } = Count.Id += 1;
    public Book Book { get; }
    public Member Member { get; }
    public int BorrowDate { get; }
    public int DueDate { get; }

    public Transaction(Book book, Member member)
    {
        Book = Book;
        Member = member;
        BorrowDate = 0;
        DueDate = BorrowDate + (member.Membership.MaxDays);
    }
}

public class Library
{
    public List<Book> books = new List<Book>();
    public List<Transaction> transaction = new();
    public List<Member> members = new();

    public Library()
    {
        // initialize data here
    }


    public Transaction BorrowBookByTitle(string title, Member member)
    {
        var book = books.Find(b => b.Title.Equals(title));
        if (book != null)
        {
            throw new BookUnavailableException("book not found");
        }
        if (!book.isAvailable)
        {
            throw new BookUnavailableException("book not available");
        }

        book.ReturnDate = 0 + member.Membership.MaxDays;
        member.BorrowBook(book);
        Transaction transaction = new Transaction(book, member);
        transactions.Add(transaction);

        PrintTransaction(transaction);
    }

    public int LateReturnFEE(int returnDate, int DueDate)
    {
        if (returnDate <= DueDate) return 0;
        int latDays = (returnDate - DueDate).Days;
        return latDays * 10;
    }
    public Transaction ReturnBook(Book book, Member member, int returnDate)
    {
        book.Return();
        member.ReturnBook();
        var fee = LateReturnFEE(returnDate, book.ReturnDate);
        Console.WriteLine("----------------------------------------------------");
        Console.WriteLine("Recipt");
        Console.WriteLine("----------------------------------------------------");
        Console.WriteLine("Transaction ID: " + Count.Id + 1);
        Console.WriteLine("Titel: " + book.Title);
        Console.WriteLine("LateFee: " + fee);
        Console.WriteLine("----------------------------------------------------");
    }

    public void PrintTransaction(Transaction transaction)
    {
        Console.WriteLine("----------------------------------------------------");
        Console.WriteLine("Recipt");
        Console.WriteLine("----------------------------------------------------");
        Console.WriteLine("Transaction ID: " + transaction.TransactionId);
        Console.WriteLine("Titel: " + transaction.Book.Title);
        Console.WriteLine("Name: " + transaction.Member.Title);
        Console.WriteLine("Borrow: " + transaction.BorrowDate);
        Console.WriteLine("Expire: " + transaction.DueDate);
        Console.WriteLine("----------------------------------------------------");
    }

}

public class Admin
{
    private readonly Library _library;
    public Admin(Library library)
    {
        _library = library;
    }

    public void AddBook(Book book)
    {
        _library.books.Add(book);
    }
    public void RemoveBook(Book book)
    {
        _library.books.Remove(book);
    }
}

public class LMS
{
    public static void Main(string[] args)
    {
        public Library
}
}