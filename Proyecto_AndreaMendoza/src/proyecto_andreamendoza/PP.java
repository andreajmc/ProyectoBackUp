package proyecto_andreamendoza;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class PP extends javax.swing.JFrame {

    static ArrayList<Usuario> Users = new ArrayList();
    static ArrayList<String> UNs = new ArrayList();
    Usuario USER = new Usuario();

    public PP() {
        this.Recycle = new ArrayList();
        initComponents();
        LogIn.setVisible(true);
        LogIn.setLocationRelativeTo(null);
        CurrentDateTime();
        UNs.add("andreaj");
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        agenda.setDefaultRenderer(String.class, centerRenderer);
        Sistema = new File("./Sistema");
        Sistema.mkdir();
        TimeThread t = new TimeThread(Time);
        Thread t2 = new Thread(t);
        t2.start();
        bm = new BarMusic(MusicPB);
        CodeWords.add("mkdir");
        CodeWords.add("rm");
        CodeWords.add("cd");
        CodeWords.add("cd...");
        CodeWords.add("dir");
        CodeWords.add("date");
        CodeWords.add("time");
        CodeWords.add("help");
        DefaultTreeModel m = (DefaultTreeModel) TreeArchives.getModel();
        DefaultMutableTreeNode Root = (DefaultMutableTreeNode) m.getRoot();
        SetTrees(new File("./Sistema/"), Root);
        txt.setContentType("text/html");

    }

    private void CurrentDateTime() {
        Calendar cal = new GregorianCalendar();
        Date Fecha = new Date();
        Fecha.setDate(cal.get(cal.DAY_OF_MONTH));
        Fecha.setMonth(cal.get(cal.MONTH));
        Fecha.setYear(cal.get((cal.YEAR)));
        DateFormat f = new SimpleDateFormat("dd/MM/YY");
        Date.setText(f.format(Fecha));
    }

    private void SetTrees(File Root, DefaultMutableTreeNode nodo) {
        try {
            for (File temp : Root.listFiles()) {
                if (temp.isFile()) {
                    DefaultMutableTreeNode n = new DefaultMutableTreeNode(temp.getName());
                    nodo.add(n);
                    PathsNodes.add(temp.getPath());
                } else {
                    DefaultMutableTreeNode n = new DefaultMutableTreeNode(temp.getName());
                    nodo.add(n);
                    PathsNodes.add(temp.getPath());
                    SetTrees(temp, n);
                }
            }
        } catch (Exception e) {
        }
    }

    static private void CreateSubDirs(String Name) {
        // BasicFileAttributes f;
        File f = new File("./Sistema/" + Name);
        f.mkdir();
        f = new File("./Sistema/" + Name + "/Mis Imágenes");
        f.mkdir();
        f = new File("./Sistema/" + Name + "/Mis Documentos");
        f.mkdir();
        f = new File("./Sistema/" + Name + "/Mi Música");
        f.mkdir();
        f = new File("./Sistema/" + Name + "/Mi Calendario");
        f.mkdir();
        f = new File("./Sistema/" + Name + "/Mis Mensajes");
        f.mkdir();
        f = new File("./Sistema/" + Name + "/Mi Correo");
        f.mkdir();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogIn = new javax.swing.JFrame();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jt_userlogin = new javax.swing.JTextField();
        pf_pwlogin = new javax.swing.JPasswordField();
        b_login = new javax.swing.JButton();
        b_cancel = new javax.swing.JButton();
        b_shutdown = new javax.swing.JButton();
        jb_forgotpw = new javax.swing.JButton();
        bg = new javax.swing.JLabel();
        PopUpMain = new javax.swing.JPopupMenu();
        m_changebg1 = new javax.swing.JMenuItem();
        m_changecolor1 = new javax.swing.JMenuItem();
        m_help = new javax.swing.JMenuItem();
        NewUser = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        tf_newuname = new javax.swing.JTextField();
        tf_newunuser = new javax.swing.JTextField();
        tf_newuemail = new javax.swing.JTextField();
        tf_newunpw = new javax.swing.JPasswordField();
        jd_newbday = new com.toedter.calendar.JDateChooser();
        s_edad = new javax.swing.JSpinner();
        cb_question = new javax.swing.JComboBox<>();
        tf_newunanswer = new javax.swing.JTextField();
        SaveNewU = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        color = new javax.swing.JLabel();
        estcolor = new javax.swing.JButton();
        AdministrarUsuarios = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MainTree = new javax.swing.JTree();
        LockUser = new javax.swing.JDialog();
        lockscreenpw = new javax.swing.JPasswordField();
        namelockscreen = new javax.swing.JLabel();
        warning = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        Archives = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TreeArchives = new javax.swing.JTree();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableArchives = new javax.swing.JTable();
        Console = new javax.swing.JDialog();
        jScrollPane6 = new javax.swing.JScrollPane();
        ConsoleText = new javax.swing.JTextArea();
        TextEditor = new javax.swing.JDialog();
        jScrollPane8 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextPane();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        SaveDoc = new javax.swing.JMenuItem();
        Netbeans = new javax.swing.JDialog();
        Agenda = new javax.swing.JDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        cal = new com.toedter.calendar.JCalendar();
        jScrollPane2 = new javax.swing.JScrollPane();
        agenda = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        Type = new javax.swing.JComboBox<>();
        Title = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        Fecha = new com.toedter.calendar.JDateChooser();
        jLabel63 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        Content = new javax.swing.JTextArea();
        start = new javax.swing.JSpinner();
        end = new javax.swing.JSpinner();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        Notes = new javax.swing.JButton();
        savedate = new javax.swing.JButton();
        Images = new javax.swing.JDialog();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        MainImage = new javax.swing.JLabel();
        Icon2 = new javax.swing.JLabel();
        Icon3 = new javax.swing.JLabel();
        Icon1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        AddImages = new javax.swing.JMenuItem();
        MusicPlayer = new javax.swing.JDialog();
        MusicPB = new javax.swing.JProgressBar();
        SongName = new javax.swing.JLabel();
        TotalTime = new javax.swing.JLabel();
        SongName1 = new javax.swing.JLabel();
        PreviousSong = new javax.swing.JButton();
        PlayPause = new javax.swing.JButton();
        NextSong = new javax.swing.JButton();
        ImportMusic = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        Playlist = new javax.swing.JList<>();
        StopButton = new javax.swing.JButton();
        Messenger = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        Contacts = new javax.swing.JList<>();
        SendM = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Message = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        Convo = new javax.swing.JTextArea();
        SocialMedia = new javax.swing.JDialog();
        Icons = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        bg1 = new javax.swing.JLabel();
        ChangeBG = new javax.swing.JDialog();
        NewBDay = new javax.swing.JDialog();
        CalendarBday = new com.toedter.calendar.JCalendar();
        jLabel2 = new javax.swing.JLabel();
        SaveBDay = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        RecycleBin = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        RecycleBinTable = new javax.swing.JTable();
        ArchivesPM = new javax.swing.JPopupMenu();
        Copy = new javax.swing.JMenuItem();
        Cut = new javax.swing.JMenuItem();
        Paste = new javax.swing.JMenuItem();
        Rename = new javax.swing.JMenuItem();
        Delete = new javax.swing.JMenuItem();
        RBPM = new javax.swing.JPopupMenu();
        Restore = new javax.swing.JMenuItem();
        DeleteP = new javax.swing.JMenuItem();
        TextPM = new javax.swing.JPopupMenu();
        EditText = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        FontChooser = new javax.swing.JDialog();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        fonts = new javax.swing.JList<>();
        jScrollPane13 = new javax.swing.JScrollPane();
        style = new javax.swing.JList<>();
        jScrollPane14 = new javax.swing.JScrollPane();
        size = new javax.swing.JList<>();
        jButton4 = new javax.swing.JButton();
        Okay = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        muestra = new javax.swing.JLabel();
        MainMenu = new javax.swing.JToolBar();
        archives = new javax.swing.JButton();
        console = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        texteditor = new javax.swing.JButton();
        calendar = new javax.swing.JButton();
        netbeans = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        images = new javax.swing.JButton();
        music = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        im = new javax.swing.JButton();
        socials = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        recycle = new javax.swing.JButton();
        Time = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();
        MenuPrincipal = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        m_admin = new javax.swing.JMenu();
        m_newuser = new javax.swing.JMenuItem();
        m_allusers = new javax.swing.JMenuItem();
        m_ajustes = new javax.swing.JMenu();
        m_newname = new javax.swing.JMenuItem();
        m_bday = new javax.swing.JMenuItem();
        m_email = new javax.swing.JMenuItem();
        m_newun = new javax.swing.JMenuItem();
        m_newpw = new javax.swing.JMenuItem();
        m_lock = new javax.swing.JMenuItem();
        m_logout = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        m_changebg = new javax.swing.JMenuItem();
        m_changecolor = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        helpicons = new javax.swing.JMenuItem();
        blankspace = new javax.swing.JMenu();
        Date = new javax.swing.JMenu();

        LogIn.setMinimumSize(new java.awt.Dimension(490, 330));
        LogIn.setResizable(false);
        LogIn.setSize(new java.awt.Dimension(490, 330));
        LogIn.getContentPane().setLayout(null);

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel45.setText("Usuario");
        LogIn.getContentPane().add(jLabel45);
        jLabel45.setBounds(60, 100, 80, 20);

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setText("Contraseña");
        LogIn.getContentPane().add(jLabel46);
        jLabel46.setBounds(60, 150, 80, 20);

        jLabel47.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel47.setText("Iniciar Sesión");
        LogIn.getContentPane().add(jLabel47);
        jLabel47.setBounds(170, 30, 170, 40);
        LogIn.getContentPane().add(jt_userlogin);
        jt_userlogin.setBounds(160, 100, 270, 28);
        LogIn.getContentPane().add(pf_pwlogin);
        pf_pwlogin.setBounds(160, 150, 270, 28);

        b_login.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        b_login.setText("Ingresar");
        b_login.setBorderPainted(false);
        b_login.setOpaque(false);
        b_login.setPreferredSize(new java.awt.Dimension(80, 31));
        b_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_loginMouseClicked(evt);
            }
        });
        LogIn.getContentPane().add(b_login);
        b_login.setBounds(160, 240, 80, 31);

        b_cancel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        b_cancel.setText("Cancelar");
        b_cancel.setOpaque(false);
        b_cancel.setPreferredSize(new java.awt.Dimension(80, 31));
        b_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_cancelMouseClicked(evt);
            }
        });
        LogIn.getContentPane().add(b_cancel);
        b_cancel.setBounds(255, 240, 80, 31);

        b_shutdown.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        b_shutdown.setText("Apagar");
        b_shutdown.setOpaque(false);
        b_shutdown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_shutdownMouseClicked(evt);
            }
        });
        LogIn.getContentPane().add(b_shutdown);
        b_shutdown.setBounds(350, 240, 80, 31);

        jb_forgotpw.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        jb_forgotpw.setForeground(new java.awt.Color(51, 51, 51));
        jb_forgotpw.setText("¿Ha olvidado su contraseña?");
        jb_forgotpw.setBorderPainted(false);
        jb_forgotpw.setContentAreaFilled(false);
        jb_forgotpw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_forgotpwMouseClicked(evt);
            }
        });
        LogIn.getContentPane().add(jb_forgotpw);
        jb_forgotpw.setBounds(280, 180, 169, 23);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/60-beach-landscape-blurred-backgrounds-7-638.jpg"))); // NOI18N
        bg.setMaximumSize(new java.awt.Dimension(338, 159));
        bg.setMinimumSize(new java.awt.Dimension(338, 159));
        bg.setPreferredSize(new java.awt.Dimension(338, 159));
        LogIn.getContentPane().add(bg);
        bg.setBounds(0, 0, 490, 300);

        m_changebg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bgc.png"))); // NOI18N
        m_changebg1.setText("Cambiar Fondo de Pantalla");
        m_changebg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_changebg1ActionPerformed(evt);
            }
        });
        PopUpMain.add(m_changebg1);

        m_changecolor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bg.png"))); // NOI18N
        m_changecolor1.setText("Cambiar Color del Sistema");
        m_changecolor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_changecolor1ActionPerformed(evt);
            }
        });
        PopUpMain.add(m_changecolor1);

        m_help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/magnifyingglass.png"))); // NOI18N
        m_help.setText("Ayuda");
        m_help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_helpActionPerformed(evt);
            }
        });
        PopUpMain.add(m_help);

        NewUser.setTitle("Nuevo Usuario");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel48.setText("Creando una nueva cuenta");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel49.setText("Con una nueva cuenta, el usuario tendrá acceso a su propia selección de ajustes, archivos, música,");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel50.setText(" imágenes y, ¡mucho más! Esto solo tomará algunos instantes.");

        tf_newuname.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tf_newuname.setText("Nombre");
        tf_newuname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearField(evt);
            }
        });

        tf_newunuser.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tf_newunuser.setText("Nombre de Usuario");
        tf_newunuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_newunuserMouseClicked(evt);
            }
        });

        tf_newuemail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tf_newuemail.setText("Correo Electrónico");
        tf_newuemail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_newuemailMouseClicked(evt);
            }
        });

        tf_newunpw.setText("Contraseña");
        tf_newunpw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_newunpwMouseClicked(evt);
            }
        });

        jd_newbday.setToolTipText("Cumpleaños");

        cb_question.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cb_question.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una pregunta...", "¿Cuál es tu color favorito?", "¿Cuál es tu superhéroe favorito?", "¿Cuál es el nombre de tu primera escuela?", "¿En qué mes nació tu mamá?", "¿Qué color fue tu primer carro?" }));

        tf_newunanswer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tf_newunanswer.setText("Respuesta");
        tf_newunanswer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_newunanswerMouseClicked(evt);
            }
        });

        SaveNewU.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        SaveNewU.setText("Guardar");
        SaveNewU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveNewUMouseClicked(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel52.setText(" y un número obligatoriamente.");

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel53.setText("La contraseña debe de contener una letra mayúscula");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel55.setText("Selecciona una pregunta de seguridad");

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel56.setText("caso de que olvides tu contraseña.");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel57.setText("que ayudará a recuperar tus datos en ");

        jLabel58.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        jLabel58.setText("Fecha de Cumpleaños y Edad");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        jLabel59.setText("Contraseña");

        color.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        color.setOpaque(true);

        estcolor.setText("Seleccionar Color del Sistema");
        estcolor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                estcolorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(estcolor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SaveNewU, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tf_newuname, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(tf_newuemail, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_newunanswer)
                                    .addComponent(cb_question, 0, 310, Short.MAX_VALUE))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel58)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(tf_newunuser, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(80, 80, 80)
                                    .addComponent(jd_newbday, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21)
                                    .addComponent(s_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel59)
                                    .addComponent(tf_newunpw, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel48)
                .addGap(18, 18, 18)
                .addComponent(jLabel49)
                .addGap(6, 6, 6)
                .addComponent(jLabel50)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_newuname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_newuemail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_newunuser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jd_newbday, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel58)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_newunpw, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel52))
                            .addComponent(jLabel53))))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(cb_question, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel55)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel57))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel56)))
                        .addGap(18, 18, 18)
                        .addComponent(tf_newunanswer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SaveNewU, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estcolor)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(32, 32, 32))
        );

        NewUser.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        AdministrarUsuarios.setTitle("Administrar Usuarios");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Z:\\");
            MainTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
            jScrollPane1.setViewportView(MainTree);

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
            );

            javax.swing.GroupLayout AdministrarUsuariosLayout = new javax.swing.GroupLayout(AdministrarUsuarios.getContentPane());
            AdministrarUsuarios.getContentPane().setLayout(AdministrarUsuariosLayout);
            AdministrarUsuariosLayout.setHorizontalGroup(
                AdministrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AdministrarUsuariosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            AdministrarUsuariosLayout.setVerticalGroup(
                AdministrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdministrarUsuariosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            LockUser.setTitle("Pantalla Bloqueada");
            LockUser.setMinimumSize(new java.awt.Dimension(1043, 680));
            LockUser.setResizable(false);
            LockUser.setSize(new java.awt.Dimension(1043, 680));
            LockUser.getContentPane().setLayout(null);

            lockscreenpw.setForeground(new java.awt.Color(153, 153, 153));
            lockscreenpw.setOpaque(false);
            lockscreenpw.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    lockscreenpwMouseClicked(evt);
                }
            });
            LockUser.getContentPane().add(lockscreenpw);
            lockscreenpw.setBounds(380, 360, 270, 30);

            namelockscreen.setFont(new java.awt.Font("Century Gothic", 2, 24)); // NOI18N
            namelockscreen.setForeground(new java.awt.Color(153, 153, 153));
            namelockscreen.setText("Nombre de Usuario");
            LockUser.getContentPane().add(namelockscreen);
            namelockscreen.setBounds(400, 320, 240, 30);

            warning.setForeground(new java.awt.Color(153, 153, 153));
            warning.setText("Ingrese contraseña para desbloquear.");
            LockUser.getContentPane().add(warning);
            warning.setBounds(430, 360, 190, 30);

            jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/default-avatar.png"))); // NOI18N
            jLabel54.setText("jLabel54");
            LockUser.getContentPane().add(jLabel54);
            jLabel54.setBounds(460, 200, 100, 100);

            jButton1.setText("Desbloquear");
            jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButton1MouseClicked(evt);
                }
            });
            LockUser.getContentPane().add(jButton1);
            jButton1.setBounds(460, 410, 100, 23);

            jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Black-Wallpaper-HD.jpg"))); // NOI18N
            LockUser.getContentPane().add(jLabel60);
            jLabel60.setBounds(0, 0, 1350, 910);

            Archives.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            Archives.setTitle("Navegador de Archivos");
            Archives.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent evt) {
                    ArchivesClosed(evt);
                }
            });

            treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Sistema");
            TreeArchives.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
            TreeArchives.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    TreeArchivesMouseClicked(evt);
                }
            });
            jScrollPane3.setViewportView(TreeArchives);

            javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
            jPanel4.setLayout(jPanel4Layout);
            jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
            );
            jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
            );

            jScrollPane5.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jScrollPane5MouseClicked(evt);
                }
            });

            TableArchives.setAutoCreateRowSorter(true);
            TableArchives.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
            TableArchives.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Nombre", "Fecha de modificación", "Tipo", "Tamaño"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            TableArchives.setGridColor(new java.awt.Color(255, 255, 255));
            TableArchives.setShowHorizontalLines(false);
            TableArchives.setShowVerticalLines(false);
            TableArchives.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    TableArchivesMouseClicked(evt);
                }
            });
            jScrollPane5.setViewportView(TableArchives);

            javax.swing.GroupLayout ArchivesLayout = new javax.swing.GroupLayout(Archives.getContentPane());
            Archives.getContentPane().setLayout(ArchivesLayout);
            ArchivesLayout.setHorizontalGroup(
                ArchivesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ArchivesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addContainerGap())
            );
            ArchivesLayout.setVerticalGroup(
                ArchivesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArchivesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(ArchivesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGap(17, 17, 17))
            );

            Console.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            Console.setTitle("Consola");
            Console.setMinimumSize(new java.awt.Dimension(630, 370));

            ConsoleText.setBackground(new java.awt.Color(0, 0, 0));
            ConsoleText.setColumns(20);
            ConsoleText.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
            ConsoleText.setForeground(new java.awt.Color(204, 204, 204));
            ConsoleText.setRows(5);
            ConsoleText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
            ConsoleText.setMaximumSize(null);
            ConsoleText.setMinimumSize(new java.awt.Dimension(630, 370));
            ConsoleText.setPreferredSize(new java.awt.Dimension(630, 370));
            ConsoleText.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    ConsoleTextKeyPressed(evt);
                }
            });
            jScrollPane6.setViewportView(ConsoleText);

            Console.getContentPane().add(jScrollPane6, java.awt.BorderLayout.CENTER);

            TextEditor.setTitle("Editor de Texto");

            txt.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    txtMouseClicked(evt);
                }
            });
            jScrollPane8.setViewportView(txt);

            jMenu4.setText("File");

            Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
            Open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/newuser.png"))); // NOI18N
            Open.setText("Abrir Documento...");
            Open.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    OpenActionPerformed(evt);
                }
            });
            jMenu4.add(Open);

            SaveDoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
            SaveDoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
            SaveDoc.setText("Guardar");
            SaveDoc.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    SaveDocActionPerformed(evt);
                }
            });
            jMenu4.add(SaveDoc);

            jMenuBar3.add(jMenu4);

            TextEditor.setJMenuBar(jMenuBar3);

            javax.swing.GroupLayout TextEditorLayout = new javax.swing.GroupLayout(TextEditor.getContentPane());
            TextEditor.getContentPane().setLayout(TextEditorLayout);
            TextEditorLayout.setHorizontalGroup(
                TextEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
            );
            TextEditorLayout.setVerticalGroup(
                TextEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
            );

            Netbeans.setTitle("NetBeans");

            Agenda.setTitle("Calendario & Agenda");
            Agenda.setBackground(new java.awt.Color(255, 255, 255));

            jTabbedPane1.setMinimumSize(new java.awt.Dimension(300, 426));
            jTabbedPane1.setName(""); // NOI18N

            jPanel6.setBackground(new java.awt.Color(255, 255, 255));

            cal.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    calMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
            jPanel6.setLayout(jPanel6Layout);
            jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cal, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addContainerGap())
            );

            agenda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            agenda.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Tipo", "Título", "¿Recordatorio?"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Object.class, java.lang.String.class, java.lang.Boolean.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });
            agenda.setAutoscrolls(false);
            agenda.setRowHeight(40);
            agenda.setSelectionBackground(new java.awt.Color(223, 248, 248));
            agenda.setSelectionForeground(new java.awt.Color(0, 0, 0));
            agenda.getTableHeader().setResizingAllowed(false);
            jScrollPane2.setViewportView(agenda);

            javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
            jPanel10.setLayout(jPanel10Layout);
            jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );
            jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );

            jTabbedPane1.addTab("Visualizar Agenda", jPanel10);

            jPanel12.setBackground(new java.awt.Color(255, 255, 255));

            jLabel51.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
            jLabel51.setText("Nueva Actividad");

            jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
            jLabel61.setText("Tipo de Actividad");

            Type.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
            Type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecciona un Tipo --", "Evento", "Tarea" }));
            Type.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    TypeItemStateChanged(evt);
                }
            });

            Title.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

            jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
            jLabel62.setText("Título");

            jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
            jLabel63.setText("Fecha");

            Content.setColumns(20);
            Content.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
            Content.setRows(5);
            Content.setEnabled(false);
            jScrollPane15.setViewportView(Content);

            start.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(), null, java.util.Calendar.HOUR));
            start.setEnabled(false);

            end.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1537083105508L), null, java.util.Calendar.HOUR));
            end.setEnabled(false);

            jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
            jLabel64.setText("Hora de Inicio");
            jLabel64.setEnabled(false);

            jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
            jLabel65.setText("Hora de Finalización");
            jLabel65.setEnabled(false);

            jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
            jLabel66.setText("Contenido");
            jLabel66.setEnabled(false);

            Notes.setText("Seleccionar Notas");
            Notes.setEnabled(false);

            savedate.setText("Guardar");
            savedate.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    savedateMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
            jPanel12.setLayout(jPanel12Layout);
            jPanel12Layout.setHorizontalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel61)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel62)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel51)
                                .addComponent(savedate))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel63)
                                .addComponent(jLabel64)
                                .addComponent(jLabel65)
                                .addComponent(jLabel66))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Notes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(end, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                .addComponent(start)
                                .addComponent(Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap())
            );
            jPanel12Layout.setVerticalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel51)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel61)
                        .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel62))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addGap(11, 11, 11)
                            .addComponent(Notes)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addComponent(savedate)
                    .addContainerGap())
            );

            javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
            jPanel11.setLayout(jPanel11Layout);
            jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            jTabbedPane1.addTab("Crear Apunte", jPanel11);

            javax.swing.GroupLayout AgendaLayout = new javax.swing.GroupLayout(Agenda.getContentPane());
            Agenda.getContentPane().setLayout(AgendaLayout);
            AgendaLayout.setHorizontalGroup(
                AgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
            );
            AgendaLayout.setVerticalGroup(
                AgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            Images.setTitle("Visor de Imágenes");
            Images.setBackground(new java.awt.Color(255, 255, 255));
            Images.setResizable(false);

            jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/right arrow.png"))); // NOI18N
            jButton2.setBorder(null);
            jButton2.setContentAreaFilled(false);
            jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButton2MouseClicked(evt);
                }
            });

            jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/left arrow.png"))); // NOI18N
            jButton3.setContentAreaFilled(false);
            jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButton3MouseClicked(evt);
                }
            });

            MainImage.setBackground(new java.awt.Color(243, 243, 243));
            MainImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            MainImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            MainImage.setOpaque(true);

            Icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png"))); // NOI18N
            Icon2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            Icon2.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    Icon2MouseClicked(evt);
                }
            });

            Icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png"))); // NOI18N
            Icon3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            Icon3.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    Icon3MouseClicked(evt);
                }
            });

            Icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png"))); // NOI18N
            Icon1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            Icon1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    Icon1MouseClicked(evt);
                }
            });

            jMenu1.setText("Opciones");

            AddImages.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
            AddImages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bgc.png"))); // NOI18N
            AddImages.setText("Importar Imágenes");
            AddImages.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    AddImagesActionPerformed(evt);
                }
            });
            jMenu1.add(AddImages);

            jMenuBar1.add(jMenu1);

            Images.setJMenuBar(jMenuBar1);

            javax.swing.GroupLayout ImagesLayout = new javax.swing.GroupLayout(Images.getContentPane());
            Images.getContentPane().setLayout(ImagesLayout);
            ImagesLayout.setHorizontalGroup(
                ImagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ImagesLayout.createSequentialGroup()
                    .addGroup(ImagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(290, 290, 290)
                            .addComponent(Icon2))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(MainImage, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(513, 513, 513)
                            .addComponent(Icon3))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(Icon1))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(715, 715, 715)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            ImagesLayout.setVerticalGroup(
                ImagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ImagesLayout.createSequentialGroup()
                    .addGroup(ImagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(397, 397, 397)
                            .addComponent(Icon2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(438, 438, 438)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(MainImage, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(397, 397, 397)
                            .addComponent(Icon3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(397, 397, 397)
                            .addComponent(Icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(433, 433, 433)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(21, 21, 21))
            );

            MusicPlayer.setTitle("Reproductor de Música");
            MusicPlayer.setMinimumSize(new java.awt.Dimension(360, 330));
            MusicPlayer.setResizable(false);
            MusicPlayer.setSize(new java.awt.Dimension(360, 315));
            MusicPlayer.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent evt) {
                    MusicPlayerWindowClosing(evt);
                }
            });

            SongName.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

            TotalTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            TotalTime.setText("00:00");

            SongName1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            SongName1.setText("Now Playing:");

            PreviousSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back-button.png"))); // NOI18N
            PreviousSong.setBorderPainted(false);
            PreviousSong.setContentAreaFilled(false);
            PreviousSong.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    PreviousSongMouseClicked(evt);
                }
            });
            PreviousSong.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    PreviousSongActionPerformed(evt);
                }
            });

            PlayPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/play-button.png"))); // NOI18N
            PlayPause.setBorderPainted(false);
            PlayPause.setContentAreaFilled(false);
            PlayPause.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    PlayPauseMouseClicked(evt);
                }
            });

            NextSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/next-button.png"))); // NOI18N
            NextSong.setBorderPainted(false);
            NextSong.setContentAreaFilled(false);
            NextSong.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    NextSongMouseClicked(evt);
                }
            });

            ImportMusic.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
            ImportMusic.setText("Add New Song");
            ImportMusic.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    ImportMusicMouseClicked(evt);
                }
            });

            Playlist.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
            Playlist.setModel(new DefaultListModel());
            Playlist.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    PlaylistMouseClicked(evt);
                }
            });
            jScrollPane4.setViewportView(Playlist);

            StopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/square-inside-a-circle.png"))); // NOI18N
            StopButton.setBorderPainted(false);
            StopButton.setContentAreaFilled(false);
            StopButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    StopButtonMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout MusicPlayerLayout = new javax.swing.GroupLayout(MusicPlayer.getContentPane());
            MusicPlayer.getContentPane().setLayout(MusicPlayerLayout);
            MusicPlayerLayout.setHorizontalGroup(
                MusicPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MusicPlayerLayout.createSequentialGroup()
                    .addGroup(MusicPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MusicPlayerLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(MusicPB, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(MusicPlayerLayout.createSequentialGroup()
                            .addGap(430, 430, 430)
                            .addComponent(TotalTime))
                        .addGroup(MusicPlayerLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(MusicPlayerLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(PreviousSong, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11)
                            .addComponent(PlayPause, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11)
                            .addComponent(NextSong, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(82, 82, 82)
                            .addComponent(StopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(ImportMusic))
                        .addGroup(MusicPlayerLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(MusicPlayerLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(MusicPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(MusicPlayerLayout.createSequentialGroup()
                                    .addComponent(SongName1)
                                    .addGap(11, 11, 11)
                                    .addComponent(SongName, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            MusicPlayerLayout.setVerticalGroup(
                MusicPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MusicPlayerLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(MusicPB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addComponent(TotalTime)
                    .addGap(14, 14, 14)
                    .addGroup(MusicPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(MusicPlayerLayout.createSequentialGroup()
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MusicPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(SongName1)
                                .addComponent(SongName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MusicPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PreviousSong, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PlayPause, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(NextSong, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(MusicPlayerLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(ImportMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(StopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            Messenger.setTitle("Mensajería");
            Messenger.setBackground(new java.awt.Color(255, 255, 255));

            jPanel2.setBackground(new java.awt.Color(176, 244, 244));
            jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            Contacts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contactos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 12))); // NOI18N
            Contacts.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
            Contacts.setModel(new DefaultListModel());
            Contacts.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    ContactsMouseClicked(evt);
                }
            });
            jScrollPane12.setViewportView(Contacts);

            SendM.setText("Send");
            SendM.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    SendMMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(SendM, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                    .addComponent(SendM, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37))
            );

            jPanel8.setBackground(new java.awt.Color(220, 245, 253));
            jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            Message.setColumns(20);
            Message.setRows(5);
            jScrollPane9.setViewportView(Message);

            Convo.setEditable(false);
            Convo.setColumns(20);
            Convo.setRows(5);
            Convo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Conversación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 12))); // NOI18N
            jScrollPane10.setViewportView(Convo);

            javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
            jPanel8.setLayout(jPanel8Layout);
            jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                        .addContainerGap()))
            );
            jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(109, Short.MAX_VALUE)))
            );

            javax.swing.GroupLayout MessengerLayout = new javax.swing.GroupLayout(Messenger.getContentPane());
            Messenger.getContentPane().setLayout(MessengerLayout);
            MessengerLayout.setHorizontalGroup(
                MessengerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MessengerLayout.createSequentialGroup()
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            MessengerLayout.setVerticalGroup(
                MessengerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            SocialMedia.setTitle("Red Social");

            Icons.setTitle("Ayuda");
            Icons.setBackground(new java.awt.Color(255, 255, 255));
            Icons.setMinimumSize(new java.awt.Dimension(750, 580));
            Icons.setResizable(false);
            Icons.setSize(new java.awt.Dimension(750, 580));
            Icons.getContentPane().setLayout(null);

            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Messenger.png"))); // NOI18N
            jLabel1.setText("jLabel1");
            Icons.getContentPane().add(jLabel1);
            jLabel1.setBounds(390, 280, 55, 47);

            jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Consola.png"))); // NOI18N
            jLabel5.setText("jLabel1");
            Icons.getContentPane().add(jLabel5);
            jLabel5.setBounds(40, 190, 55, 47);

            jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Archivos.png"))); // NOI18N
            jLabel6.setText("jLabel1");
            Icons.getContentPane().add(jLabel6);
            jLabel6.setBounds(40, 100, 55, 47);

            jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Calendario.png"))); // NOI18N
            jLabel7.setText("jLabel1");
            Icons.getContentPane().add(jLabel7);
            jLabel7.setBounds(40, 470, 55, 47);

            jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NetBeans.png"))); // NOI18N
            jLabel8.setText("jLabel1");
            Icons.getContentPane().add(jLabel8);
            jLabel8.setBounds(40, 370, 55, 60);

            jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Texto.png"))); // NOI18N
            Icons.getContentPane().add(jLabel9);
            jLabel9.setBounds(40, 280, 55, 47);

            jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagen.png"))); // NOI18N
            jLabel10.setText("jLabel1");
            Icons.getContentPane().add(jLabel10);
            jLabel10.setBounds(390, 190, 55, 47);

            jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Musica.png"))); // NOI18N
            jLabel11.setText("jLabel1");
            Icons.getContentPane().add(jLabel11);
            jLabel11.setBounds(390, 90, 55, 59);

            jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reciclaje.png"))); // NOI18N
            jLabel12.setText("jLabel1");
            Icons.getContentPane().add(jLabel12);
            jLabel12.setBounds(390, 460, 55, 63);

            jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/SM.png"))); // NOI18N
            jLabel13.setText("jLabel1");
            Icons.getContentPane().add(jLabel13);
            jLabel13.setBounds(390, 370, 55, 58);

            jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel14.setText("Organizador de Archivos");
            Icons.getContentPane().add(jLabel14);
            jLabel14.setBounds(110, 90, 160, 20);

            jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel15.setText("Consola");
            Icons.getContentPane().add(jLabel15);
            jLabel15.setBounds(110, 170, 51, 20);

            jLabel16.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel16.setText("Editor de Texto");
            Icons.getContentPane().add(jLabel16);
            jLabel16.setBounds(110, 260, 97, 20);

            jLabel17.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel17.setText("Netbeans");
            Icons.getContentPane().add(jLabel17);
            jLabel17.setBounds(110, 350, 60, 20);

            jLabel18.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel18.setText("Agenda & Calendario");
            Icons.getContentPane().add(jLabel18);
            jLabel18.setBounds(110, 450, 138, 20);

            jLabel19.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel19.setText("Visor de Imágenes");
            Icons.getContentPane().add(jLabel19);
            jLabel19.setBounds(470, 180, 117, 20);

            jLabel20.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel20.setText("Reproductor de Música");
            Icons.getContentPane().add(jLabel20);
            jLabel20.setBounds(470, 90, 146, 20);

            jLabel21.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel21.setText("Messenger");
            Icons.getContentPane().add(jLabel21);
            jLabel21.setBounds(470, 260, 67, 20);

            jLabel22.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel22.setText("Sociales");
            Icons.getContentPane().add(jLabel22);
            jLabel22.setBounds(470, 360, 51, 20);

            jLabel23.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel23.setText("Papelera de Reciclaje");
            Icons.getContentPane().add(jLabel23);
            jLabel23.setBounds(470, 450, 135, 20);

            jLabel24.setText("carpetas para un fácil acceso.");
            Icons.getContentPane().add(jLabel24);
            jLabel24.setBounds(110, 130, 230, 20);

            jLabel25.setText("Todos los archivos del Sistemas ordenados por");
            Icons.getContentPane().add(jLabel25);
            jLabel25.setBounds(110, 110, 230, 20);

            jLabel26.setText("Consola de comandos que muestra la carpeta ");
            Icons.getContentPane().add(jLabel26);
            jLabel26.setBounds(110, 190, 230, 20);

            jLabel27.setText("actual y presenta otra serie de funciones.");
            Icons.getContentPane().add(jLabel27);
            jLabel27.setBounds(110, 210, 230, 20);

            jLabel28.setText("Editor de texto que permite crear y modificar ");
            Icons.getContentPane().add(jLabel28);
            jLabel28.setBounds(110, 280, 230, 20);

            jLabel29.setText("archivos .txt.");
            Icons.getContentPane().add(jLabel29);
            jLabel29.setBounds(110, 300, 230, 20);

            jLabel30.setText("Módulo que permite la creación de archivos tipo");
            Icons.getContentPane().add(jLabel30);
            jLabel30.setBounds(110, 370, 230, 20);

            jLabel31.setText(".java y que implementa la metodología POO.");
            Icons.getContentPane().add(jLabel31);
            jLabel31.setBounds(110, 390, 230, 20);

            jLabel32.setText("permite la creación de eventos y tares.");
            Icons.getContentPane().add(jLabel32);
            jLabel32.setBounds(110, 500, 230, 20);

            jLabel33.setText("Organizador diario, semanal y mensual que ");
            Icons.getContentPane().add(jLabel33);
            jLabel33.setBounds(110, 480, 230, 20);

            jLabel34.setText("el navegador de archivos.");
            Icons.getContentPane().add(jLabel34);
            jLabel34.setBounds(470, 130, 230, 20);

            jLabel35.setText("Reproductor de archivos .mp3 tomados desde ");
            Icons.getContentPane().add(jLabel35);
            jLabel35.setBounds(470, 110, 230, 20);

            jLabel36.setText("Visor de imágenes que accede a una colección ");
            Icons.getContentPane().add(jLabel36);
            jLabel36.setBounds(470, 200, 230, 20);

            jLabel37.setText("de imágenes dentro de una carpeta.");
            Icons.getContentPane().add(jLabel37);
            jLabel37.setBounds(470, 220, 230, 20);

            jLabel38.setText("Un sistema de mensajería dentro del Sistema ");
            Icons.getContentPane().add(jLabel38);
            jLabel38.setBounds(470, 280, 230, 20);

            jLabel39.setText("que permite la comunicación entre usuarios.");
            Icons.getContentPane().add(jLabel39);
            jLabel39.setBounds(470, 300, 230, 20);

            jLabel40.setText("Módulo que permite compartir con grupos de ");
            Icons.getContentPane().add(jLabel40);
            jLabel40.setBounds(470, 380, 230, 20);

            jLabel41.setText("amigos entre los usuarios. ");
            Icons.getContentPane().add(jLabel41);
            jLabel41.setBounds(470, 400, 230, 20);

            jLabel42.setText("Los archivos eliminados desde el navegador ");
            Icons.getContentPane().add(jLabel42);
            jLabel42.setBounds(470, 470, 230, 20);

            jLabel43.setText("de archivos pueden ser encontrados aquí.");
            Icons.getContentPane().add(jLabel43);
            jLabel43.setBounds(470, 490, 230, 20);

            jLabel44.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
            jLabel44.setText("Menú de Íconos");
            Icons.getContentPane().add(jLabel44);
            jLabel44.setBounds(40, 0, 320, 80);
            Icons.getContentPane().add(jSeparator5);
            jSeparator5.setBounds(30, 62, 680, 10);

            bg1.setBackground(new java.awt.Color(255, 255, 255));
            bg1.setOpaque(true);
            Icons.getContentPane().add(bg1);
            bg1.setBounds(0, 70, 760, 460);

            ChangeBG.setTitle("Cambiar Fondo de Pantalla");

            NewBDay.setTitle("Modificar Cumpleaños");
            NewBDay.setBackground(new java.awt.Color(253, 240, 240));
            NewBDay.setForeground(new java.awt.Color(255, 153, 0));
            NewBDay.setMinimumSize(new java.awt.Dimension(450, 250));
            NewBDay.setResizable(false);
            NewBDay.setSize(new java.awt.Dimension(450, 250));
            NewBDay.getContentPane().setLayout(null);

            CalendarBday.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            CalendarBday.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
            NewBDay.getContentPane().add(CalendarBday);
            CalendarBday.setBounds(200, 10, 222, 189);

            jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jLabel2.setText("Seleccione una nueva fecha");
            NewBDay.getContentPane().add(jLabel2);
            jLabel2.setBounds(20, 70, 170, 16);

            SaveBDay.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
            SaveBDay.setText("Guardar");
            SaveBDay.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    SaveBDayMouseClicked(evt);
                }
            });
            NewBDay.getContentPane().add(SaveBDay);
            SaveBDay.setBounds(60, 130, 80, 25);

            jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jLabel3.setText("de Nacimiento");
            NewBDay.getContentPane().add(jLabel3);
            jLabel3.setBounds(60, 90, 100, 16);

            jLabel4.setBackground(new java.awt.Color(255, 255, 255));
            jLabel4.setForeground(new java.awt.Color(255, 236, 204));
            jLabel4.setOpaque(true);
            NewBDay.getContentPane().add(jLabel4);
            jLabel4.setBounds(0, 0, 440, 210);

            RecycleBin.setTitle("Papelera de Reciclaje");

            jScrollPane7.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jScrollPane7MouseClicked(evt);
                }
            });

            RecycleBinTable.setAutoCreateRowSorter(true);
            RecycleBinTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
            RecycleBinTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Nombre", "Fecha de modificación", "Tipo", "Tamaño"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            RecycleBinTable.setGridColor(new java.awt.Color(255, 255, 255));
            RecycleBinTable.setShowHorizontalLines(false);
            RecycleBinTable.setShowVerticalLines(false);
            RecycleBinTable.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    RecycleBinTableMouseClicked(evt);
                }
            });
            jScrollPane7.setViewportView(RecycleBinTable);

            javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
            jPanel7.setLayout(jPanel7Layout);
            jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 547, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                        .addContainerGap()))
            );
            jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 323, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap()))
            );

            RecycleBin.getContentPane().add(jPanel7, java.awt.BorderLayout.CENTER);

            Copy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/copy.png"))); // NOI18N
            Copy.setText("Copy");
            Copy.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    CopyActionPerformed(evt);
                }
            });
            ArchivesPM.add(Copy);

            Cut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cut.png"))); // NOI18N
            Cut.setText("Cut");
            Cut.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    CutActionPerformed(evt);
                }
            });
            ArchivesPM.add(Cut);

            Paste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/paste bp.png"))); // NOI18N
            Paste.setText("Paste");
            Paste.setEnabled(false);
            Paste.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    PasteActionPerformed(evt);
                }
            });
            ArchivesPM.add(Paste);

            Rename.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Edit p.png"))); // NOI18N
            Rename.setText("Rename...");
            Rename.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    RenameActionPerformed(evt);
                }
            });
            ArchivesPM.add(Rename);

            Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete tc.png"))); // NOI18N
            Delete.setText("Delete");
            Delete.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    DeleteMouseClicked(evt);
                }
            });
            Delete.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    DeleteActionPerformed(evt);
                }
            });
            ArchivesPM.add(Delete);

            Restore.setText("Restore");
            Restore.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    RestoreActionPerformed(evt);
                }
            });
            RBPM.add(Restore);

            DeleteP.setText("Delete");
            DeleteP.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    DeletePActionPerformed(evt);
                }
            });
            RBPM.add(DeleteP);

            EditText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/settings.png"))); // NOI18N
            EditText.setText("Properties");
            EditText.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    EditTextActionPerformed(evt);
                }
            });
            TextPM.add(EditText);

            Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
            Save.setText("Save");
            TextPM.add(Save);

            FontChooser.setTitle("Edit Text");

            jPanel9.setBackground(new java.awt.Color(218, 212, 206));

            fonts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Font", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 11))); // NOI18N
            fonts.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
            fonts.setModel(new DefaultListModel());
            jScrollPane11.setViewportView(fonts);

            style.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Style", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 11))); // NOI18N
            style.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
            style.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings = { "Plain", "Bold", "Italic", "Bold Italic", "Underline" };
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
            });
            style.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            jScrollPane13.setViewportView(style);

            size.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Size", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 11))); // NOI18N
            size.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
            size.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings = { "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72" };
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
            });
            size.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            jScrollPane14.setViewportView(size);

            jButton4.setText("Cancel");
            jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButton4MouseClicked(evt);
                }
            });

            Okay.setText("OK");
            Okay.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    OkayMouseClicked(evt);
                }
            });

            jButton5.setText("Elegir Color");
            jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButton5MouseClicked(evt);
                }
            });

            muestra.setBackground(new java.awt.Color(0, 0, 0));
            muestra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            muestra.setOpaque(true);

            javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
            jPanel9.setLayout(jPanel9Layout);
            jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(muestra, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton5)
                            .addGap(60, 60, 60)
                            .addComponent(Okay)
                            .addGap(6, 6, 6)
                            .addComponent(jButton4))))
            );
            jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(muestra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Okay)
                                    .addComponent(jButton4))
                                .addComponent(jButton5))))
                    .addContainerGap())
            );

            javax.swing.GroupLayout FontChooserLayout = new javax.swing.GroupLayout(FontChooser.getContentPane());
            FontChooser.getContentPane().setLayout(FontChooserLayout);
            FontChooserLayout.setHorizontalGroup(
                FontChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            FontChooserLayout.setVerticalGroup(
                FontChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("Windows Simulator");
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            setMaximumSize(new java.awt.Dimension(1043, 680));
            setMinimumSize(new java.awt.Dimension(1043, 680));
            setPreferredSize(new java.awt.Dimension(1043, 680));
            setResizable(false);
            setSize(new java.awt.Dimension(1043, 680));
            addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    PopUpMenu(evt);
                }
            });
            getContentPane().setLayout(null);

            MainMenu.setBackground(new java.awt.Color(245, 221, 221));
            MainMenu.setForeground(new java.awt.Color(204, 204, 255));
            MainMenu.setRollover(true);

            archives.setBackground(new java.awt.Color(245, 221, 221));
            archives.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Archivos.png"))); // NOI18N
            archives.setFocusable(false);
            archives.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            archives.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            archives.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    archivesMouseClicked(evt);
                }
            });
            archives.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    archivesActionPerformed(evt);
                }
            });
            MainMenu.add(archives);

            console.setBackground(new java.awt.Color(245, 221, 221));
            console.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Consola.png"))); // NOI18N
            console.setFocusable(false);
            console.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            console.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            console.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    consoleMouseClicked(evt);
                }
            });
            MainMenu.add(console);
            MainMenu.add(jSeparator1);

            texteditor.setBackground(new java.awt.Color(245, 221, 221));
            texteditor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Texto.png"))); // NOI18N
            texteditor.setFocusable(false);
            texteditor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            texteditor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            texteditor.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    texteditorMouseClicked(evt);
                }
            });
            MainMenu.add(texteditor);

            calendar.setBackground(new java.awt.Color(245, 221, 221));
            calendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Calendario.png"))); // NOI18N
            calendar.setFocusable(false);
            calendar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            calendar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            calendar.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    calendarMouseClicked(evt);
                }
            });
            MainMenu.add(calendar);

            netbeans.setBackground(new java.awt.Color(245, 221, 221));
            netbeans.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NetBeans.png"))); // NOI18N
            netbeans.setFocusable(false);
            netbeans.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            netbeans.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            netbeans.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    netbeansMouseClicked(evt);
                }
            });
            MainMenu.add(netbeans);
            MainMenu.add(jSeparator2);

            images.setBackground(new java.awt.Color(245, 221, 221));
            images.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagen.png"))); // NOI18N
            images.setFocusable(false);
            images.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            images.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            images.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    imagesMouseClicked(evt);
                }
            });
            MainMenu.add(images);

            music.setBackground(new java.awt.Color(245, 221, 221));
            music.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Musica.png"))); // NOI18N
            music.setFocusable(false);
            music.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            music.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            music.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    musicMouseClicked(evt);
                }
            });
            MainMenu.add(music);
            MainMenu.add(jSeparator3);

            im.setBackground(new java.awt.Color(245, 221, 221));
            im.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Messenger.png"))); // NOI18N
            im.setFocusable(false);
            im.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            im.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            im.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    imMouseClicked(evt);
                }
            });
            MainMenu.add(im);

            socials.setBackground(new java.awt.Color(245, 221, 221));
            socials.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/SM.png"))); // NOI18N
            socials.setFocusable(false);
            socials.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            socials.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            socials.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    socialsMouseClicked(evt);
                }
            });
            MainMenu.add(socials);
            MainMenu.add(jSeparator4);

            recycle.setBackground(new java.awt.Color(245, 221, 221));
            recycle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reciclaje.png"))); // NOI18N
            recycle.setFocusable(false);
            recycle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            recycle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            recycle.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    recycleMouseClicked(evt);
                }
            });
            recycle.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    recycleActionPerformed(evt);
                }
            });
            MainMenu.add(recycle);

            getContentPane().add(MainMenu);
            MainMenu.setBounds(200, 570, 610, 60);

            Time.setBackground(new java.awt.Color(255, 255, 255));
            Time.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            Time.setText("00:00");
            Time.setOpaque(true);
            getContentPane().add(Time);
            Time.setBounds(970, 610, 80, 20);

            BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/KjyvQ6I.jpg"))); // NOI18N
            getContentPane().add(BG);
            BG.setBounds(0, 0, 1050, 630);

            File.setText("File");

            m_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Home.png"))); // NOI18N
            m_admin.setText("Administrador");
            m_admin.setEnabled(false);
            m_admin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

            m_newuser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
            m_newuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/newuser.png"))); // NOI18N
            m_newuser.setText("Nuevo Usuario");
            m_newuser.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_newuserActionPerformed(evt);
                }
            });
            m_admin.add(m_newuser);

            m_allusers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/adminu.png"))); // NOI18N
            m_allusers.setText("Administrar Usuarios");
            m_allusers.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_allusersActionPerformed(evt);
                }
            });
            m_admin.add(m_allusers);

            File.add(m_admin);

            m_ajustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Edit p.png"))); // NOI18N
            m_ajustes.setText("Ajustes");

            m_newname.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
            m_newname.setText("Cambiar Display Name");
            m_newname.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_newnameActionPerformed(evt);
                }
            });
            m_ajustes.add(m_newname);

            m_bday.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
            m_bday.setText("Cambiar Cumpleaños");
            m_bday.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_bdayActionPerformed(evt);
                }
            });
            m_ajustes.add(m_bday);

            m_email.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
            m_email.setText("Cambiar Correo Electrónico");
            m_email.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_emailActionPerformed(evt);
                }
            });
            m_ajustes.add(m_email);

            m_newun.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
            m_newun.setText("Cambiar Nombre de Usuario");
            m_newun.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_newunActionPerformed(evt);
                }
            });
            m_ajustes.add(m_newun);

            m_newpw.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
            m_newpw.setText("Cambiar Contraseña");
            m_newpw.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_newpwActionPerformed(evt);
                }
            });
            m_ajustes.add(m_newpw);

            File.add(m_ajustes);

            m_lock.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
            m_lock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lock (7).png"))); // NOI18N
            m_lock.setText("Bloquear");
            m_lock.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_lockActionPerformed(evt);
                }
            });
            File.add(m_lock);

            m_logout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
            m_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logout.png"))); // NOI18N
            m_logout.setText("Log Out");
            m_logout.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_logoutActionPerformed(evt);
                }
            });
            File.add(m_logout);

            MenuPrincipal.add(File);

            Edit.setText("Edit");

            m_changebg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bgc.png"))); // NOI18N
            m_changebg.setText("Cambiar Fondo de Pantalla");
            m_changebg.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_changebgActionPerformed(evt);
                }
            });
            Edit.add(m_changebg);

            m_changecolor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bg.png"))); // NOI18N
            m_changecolor.setText("Cambiar Color del Sistema");
            m_changecolor.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_changecolorActionPerformed(evt);
                }
            });
            Edit.add(m_changecolor);

            MenuPrincipal.add(Edit);

            Help.setText("Help");

            helpicons.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
            helpicons.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/List.png"))); // NOI18N
            helpicons.setText("Ayuda Íconos");
            helpicons.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    helpiconsActionPerformed(evt);
                }
            });
            Help.add(helpicons);

            MenuPrincipal.add(Help);

            blankspace.setText("                                                                                                                                                                                                                                                                                                       ");
            blankspace.setEnabled(false);
            MenuPrincipal.add(blankspace);

            Date.setText("Date");
            Date.setEnabled(false);
            Date.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
            MenuPrincipal.add(Date);

            setJMenuBar(MenuPrincipal);

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void PopUpMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PopUpMenu
        if (evt.isMetaDown()) {
            PopUpMain.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_PopUpMenu

    private void m_helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_helpActionPerformed
        Icons.setVisible(true);
        Icons.setLocationRelativeTo(null);
    }//GEN-LAST:event_m_helpActionPerformed

    private void m_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_logoutActionPerformed
        m_admin.setEnabled(false);
        TreeArchives.setModel(null);
        ((DefaultTableModel) TableArchives.getModel()).setRowCount(0);
        setVisible(false);
        LogIn.setVisible(true);
        LogIn.setLocationRelativeTo(null);
    }//GEN-LAST:event_m_logoutActionPerformed

    private void m_changebgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_changebgActionPerformed
        JFileChooser FChooser = new JFileChooser();
        FileFilter Filter = new FileNameExtensionFilter("Imágenes",
                "png", "jpg", "jpeg", "gif");
        FChooser.setFileFilter(Filter);
        File archive = null;
        int op = FChooser.showOpenDialog(this);
        if (op == JFileChooser.APPROVE_OPTION) {
            archive = FChooser.getSelectedFile();
        }
        ImageIcon newBG = new ImageIcon(archive.getPath());
        BG.setIcon(newBG);
        JOptionPane.showMessageDialog(this, "¡Cambios aplicados exitósamente!");
    }//GEN-LAST:event_m_changebgActionPerformed

    private void m_changecolorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_changecolorActionPerformed
        Color C = JColorChooser.showDialog(this, "Seleccione un nuevo color para el sistema.", Color.yellow);
        MainMenu.setBackground(C);
        archives.setBackground(C);
        console.setBackground(C);
        im.setBackground(C);
        images.setBackground(C);
        music.setBackground(C);
        netbeans.setBackground(C);
        socials.setBackground(C);
        texteditor.setBackground(C);
        calendar.setBackground(C);
        recycle.setBackground(C);
        USER.setC(C);
        Time.setBackground(C);
        MusicPB.setForeground(C);
    }//GEN-LAST:event_m_changecolorActionPerformed

    private void m_bdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_bdayActionPerformed
        NewBDay.setVisible(true);
        NewBDay.setLocationRelativeTo(this);
    }//GEN-LAST:event_m_bdayActionPerformed

    private void m_lockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_lockActionPerformed
        LockUser.setLocationRelativeTo(null);
        LockUser.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_m_lockActionPerformed

    private void m_newnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_newnameActionPerformed
        File f = new File("./Sistema/" + USER.getNombre());
        USER.setNombre(JOptionPane.showInputDialog(this, "Ingrese un nuevo nombre: "));
        f.renameTo(new File("./Sistema/" + USER.getNombre()));
        JOptionPane.showMessageDialog(this, "¡Cambio realizado exitósamente.");
    }//GEN-LAST:event_m_newnameActionPerformed

    private void m_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_emailActionPerformed
        boolean v = false;
        while (v == false) {
            try {
                USER.setCorreo(JOptionPane.showInputDialog(this, "Ingrese un nuevo correo electrónico: "));
                JOptionPane.showMessageDialog(this, "¡Cambio realizado exitósamente!");
                v = true;
            } catch (Exceptions x) {
                JOptionPane.showMessageDialog(this, x);
            }
        }
    }//GEN-LAST:event_m_emailActionPerformed

    private void m_newunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_newunActionPerformed
        boolean v = false;
        while (v == false) {
            try {
                USER.setUsername(JOptionPane.showInputDialog(this, "Ingrese un nuevo nombre de usuario: "));
                JOptionPane.showMessageDialog(this, "¡Cambio realizado exitósamente!");
                v = true;
            } catch (Exceptions x) {
                JOptionPane.showMessageDialog(this, x);
            }
        }
    }//GEN-LAST:event_m_newunActionPerformed

    private void m_newpwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_newpwActionPerformed
        boolean v = false;
        while (v == false) {
            try {
                USER.setPW(JOptionPane.showInputDialog(this, "Ingrese un nueva contraseña: "));
                JOptionPane.showMessageDialog(this, "¡Cambio realizado exitósamente!");
                v = true;
            } catch (Exceptions x) {
                JOptionPane.showMessageDialog(this, x);
            }
        }
    }//GEN-LAST:event_m_newpwActionPerformed

    private void SaveBDayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveBDayMouseClicked
        USER.setBday(CalendarBday.getDate());
        JOptionPane.showMessageDialog(this, "¡Fecha cambiada exitósamente!");
        NewBDay.setVisible(false);
    }//GEN-LAST:event_SaveBDayMouseClicked

    private void recycleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recycleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recycleActionPerformed

    private void b_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_loginMouseClicked
        String un = jt_userlogin.getText();
        String pw = pf_pwlogin.getText();
        for (Usuario U : Users) {
            if (U.getUsername().equalsIgnoreCase(un) && U.getPW().equals(pw)) {
                USER = U;
                Color C = USER.getC();
                MainMenu.setBackground(C);
                archives.setBackground(C);
                console.setBackground(C);
                im.setBackground(C);
                images.setBackground(C);
                music.setBackground(C);
                netbeans.setBackground(C);
                socials.setBackground(C);
                texteditor.setBackground(C);
                calendar.setBackground(C);
                recycle.setBackground(C);
                SaveNewU.setBackground(C);
                Time.setBackground(C);
                MusicPB.setForeground(C);
                //set jtree de navegador
                if (USER instanceof Administrador) {
                    m_admin.setEnabled(true);
                }
                jt_userlogin.setText("");
                pf_pwlogin.setText("");
                pf_pwlogin.setBackground(Color.WHITE);
                namelockscreen.setText(USER.getNombre());
                LogIn.setVisible(false);
                this.setVisible(true);
                this.setLocationRelativeTo(null);
                if (USER.isMsn()) {
                    int resp = JOptionPane.showConfirmDialog(this, "¡Tiene un mensaje nuevo!\n¿Desea leerlo ahora?");
                    if (resp == JOptionPane.YES_OPTION) {
                        Messenger.pack();
                        Messenger.setLocationRelativeTo(null);
                        Messenger.setVisible(true);
                    }
                    USER.setMsn(false);
                }
                break;
            } else if (U.getUsername().equalsIgnoreCase(un) && (!U.getPW().equals(pw))) {
                pf_pwlogin.setBackground(Color.pink);
                JOptionPane.showMessageDialog(LogIn, "Contraseña incorrecta.\nInténtelo de nuevo.");
                pf_pwlogin.setText("");
                break;
            } else if (Users.indexOf(U) == Users.size() - 1 && (!U.getNombre().equals(un))) {
                JOptionPane.showMessageDialog(LogIn, "El usuario ingresado no existe.\nInténtelo de nuevo con otro usuario o contacte el administrador del equipo.");
                jt_userlogin.setText("");
                pf_pwlogin.setText("");
            }

        }
    }//GEN-LAST:event_b_loginMouseClicked

    private void b_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_cancelMouseClicked
        jt_userlogin.setText("");
        pf_pwlogin.setText("");
    }//GEN-LAST:event_b_cancelMouseClicked

    private void b_shutdownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_shutdownMouseClicked
        int resp = JOptionPane.showConfirmDialog(this, "¿Desea salir del Sistema?");
        if (resp == JOptionPane.YES_OPTION) {
            RecycleBinTable.removeAll();
            File RB = new File("./Papelera de Reciclaje");
            for (File f : RB.listFiles()) {
                f.delete();
            }
            BinaryArchivesAdmin BAA = new BinaryArchivesAdmin("./User Information.aj");
            BAA.loadArchive();
            BAA.setUsers(Users);
            BAA.overrideArchive();
            System.exit(0);
        }
    }//GEN-LAST:event_b_shutdownMouseClicked

    private void jb_forgotpwMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_forgotpwMouseClicked
        String UN = JOptionPane.showInputDialog(LogIn, "Ingrese su nombre de usuario:");
        String Pregunta = "";
        for (Usuario User : Users) {
            if (User.getUsername().equalsIgnoreCase(UN)) {
                JOptionPane.showMessageDialog(LogIn, "Para recuperar su contraseña, es necesario que responda correctamente la pregunta de seguridad.");
                Pregunta = User.getPregunta();
                String Resp = JOptionPane.showInputDialog(LogIn, Pregunta);
                if (Resp.equalsIgnoreCase(User.getRespPW())) {
                    JOptionPane.showMessageDialog(LogIn, "Su contraseña es: " + User.getPW());
                } else {
                    JOptionPane.showMessageDialog(LogIn, "Respuesta incorrecta. \nInténtelo de nuevo.");
                }
                break;
            }
            if (Users.indexOf(User) == Users.size() - 1) {
                JOptionPane.showMessageDialog(LogIn, "El nombre de usuario ingresado no se encuentra registrado.");
            }
        }
    }//GEN-LAST:event_jb_forgotpwMouseClicked

    private void m_changecolor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_changecolor1ActionPerformed
        Color C = JColorChooser.showDialog(null, "Seleccione un nuevo color para el sistema.", Color.yellow);
        USER.setC(C);
        MainMenu.setBackground(C);
        archives.setBackground(C);
        console.setBackground(C);
        im.setBackground(C);
        images.setBackground(C);
        music.setBackground(C);
        netbeans.setBackground(C);
        socials.setBackground(C);
        texteditor.setBackground(C);
        calendar.setBackground(C);
        recycle.setBackground(C);
        SaveNewU.setBackground(C);
        Time.setBackground(C);
        MusicPB.setForeground(C);
    }//GEN-LAST:event_m_changecolor1ActionPerformed

    private void helpiconsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpiconsActionPerformed
        Icons.pack();
        Icons.setLocationRelativeTo(this);
        Icons.setVisible(true);

    }//GEN-LAST:event_helpiconsActionPerformed

    private void archivesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archivesMouseClicked
        Archives.pack();
        Archives.setLocationRelativeTo(this);
        Archives.setVisible(true);
        TreeArchives.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        DefaultTreeModel m = (DefaultTreeModel) TreeArchives.getModel();
        DefaultTableModel m2 = (DefaultTableModel) TableArchives.getModel();
        m.setRoot(new DefaultMutableTreeNode("Sistema"));

        if (USER instanceof Administrador) {
            DefaultMutableTreeNode Root = (DefaultMutableTreeNode) m.getRoot();
            SetTrees(new File("./Sistema/"), Root);
            m.reload();
        } else {

            if (!flag) {
                m.setRoot(new DefaultMutableTreeNode("Sistema"));
                flag = true;
            }

            DefaultMutableTreeNode Root = new DefaultMutableTreeNode(m.getRoot().toString());
            DefaultMutableTreeNode Child = new DefaultMutableTreeNode(USER.getNombre());
            Root.add(Child);
            m.setRoot(Root);
            SetTrees(new File("./Sistema/" + USER.getNombre()), Child);
            m.reload();
        }
        m2.setRowCount(0);
    }//GEN-LAST:event_archivesMouseClicked

    private void consoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consoleMouseClicked
        currentpath = "./Sistema/" + USER.getNombre();
        pathaesthetic = "Sistema:\\\\" + USER.getNombre() + ">";
        ConsoleText.append("Mini Windows [Versión 1.00]\n"
                + "(c) 2018 Andrea J. Mendoza. Todos los derechos reservados.\n\nSistema:\\" + USER.getNombre() + ">");
        Console.pack();
        Console.setLocationRelativeTo(this);
        Console.setVisible(true);
    }//GEN-LAST:event_consoleMouseClicked

    private void texteditorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_texteditorMouseClicked
        txt.setContentType("text/html");
        TextEditor.pack();
        TextEditor.setLocationRelativeTo(this);
        TextEditor.setVisible(true);
    }//GEN-LAST:event_texteditorMouseClicked

    private void calendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarMouseClicked
        Agenda.pack();
        Agenda.setLocationRelativeTo(this);
        Agenda.setVisible(true);

    }//GEN-LAST:event_calendarMouseClicked

    private void netbeansMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_netbeansMouseClicked
        Netbeans.pack();
        Netbeans.setLocationRelativeTo(this);
        Netbeans.setVisible(true);

    }//GEN-LAST:event_netbeansMouseClicked

    private void imagesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagesMouseClicked
        I.removeAll(I); //*
        Images.getContentPane().setBackground(Color.WHITE);
        File Imagenes = new File("./Sistema/" + USER.getNombre() + USER.getCImagenes());
        if (Imagenes.listFiles().length <= 0) {
            JOptionPane.showMessageDialog(this, "No se han encontrado imágenes asociadas a su carpeta."
                    + "\nAgregue archivos para poder visualizarlos correctamente.");
            try {
                JFileChooser FChooser = new JFileChooser();
                FileFilter Filter;
                Filter = new FileNameExtensionFilter("Imágenes",
                        "png", "jpg", "jpeg", "gif");
                FChooser.setFileFilter(Filter);
                File archive;
                int op = FChooser.showOpenDialog(this);
                if (op == JFileChooser.APPROVE_OPTION) {
                    archive = FChooser.getSelectedFile();
                    Image img = Toolkit.getDefaultToolkit().createImage(
                            archive.getPath());
                    I.add(img);
                    Files.copy(Paths.get(archive.getPath()),
                            Paths.get("./Sistema/"
                                    + USER.getNombre()
                                    + USER.getCImagenes() + "/"
                                    + archive.getName()),
                            StandardCopyOption.REPLACE_EXISTING);
                }
                ImageIcon imageIcon = new ImageIcon(I.get(0));
                Image image = imageIcon.getImage();
                Image newimg = image.getScaledInstance(-1, 373, java.awt.Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(newimg);
                MainImage.setIcon(imageIcon);
            } catch (Exception e) {
            }
        } else {
            for (int i = 0; i < Imagenes.listFiles().length; i++) {
                Image ig = Toolkit.getDefaultToolkit().createImage(Imagenes.listFiles()[i].getPath());
                I.add(ig);
                if (i < 3) {
                    if (I.size() >= 3) {
                        ig1 = I.get(pos1);
                        ig2 = I.get(pos2);
                        ig3 = I.get(pos3);
                        ig4 = ig1.getScaledInstance(190, 122, 0);
                        ig5 = ig2.getScaledInstance(190, 122, 0);
                        ig6 = ig3.getScaledInstance(190, 122, 0);
                        Icon1.setIcon(new ImageIcon(ig4));
                        Icon2.setIcon(new ImageIcon(ig5));
                        Icon3.setIcon(new ImageIcon(ig6));
                        i1 = true;
                        i2 = true;
                        i3 = true;
                    } else if (I.size() == 1) {
                        ig1 = I.get(pos1);
                        ig4 = ig1.getScaledInstance(190, 122, 0);
                        Icon1.setIcon(new ImageIcon(ig4));
                        i1 = true;
                    } else if (I.size() == 2) {
                        ig1 = I.get(pos1);
                        ig2 = I.get(pos2);
                        ig4 = ig1.getScaledInstance(190, 122, 0);
                        ig5 = ig2.getScaledInstance(190, 122, 0);
                        Icon1.setIcon(new ImageIcon(ig4));
                        Icon2.setIcon(new ImageIcon(ig5));
                        i1 = true;
                        i2 = true;
                    }
                }
            }
            ImageIcon imageIcon = new ImageIcon(ig1);
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(-1, 373, java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);
            MainImage.setIcon(imageIcon);
        }
        Images.pack();
        Images.setLocationRelativeTo(this);
        Images.setVisible(true);
    }//GEN-LAST:event_imagesMouseClicked

    private void musicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musicMouseClicked
        bm.start();
        com.sun.javafx.application.PlatformImpl.startup(() -> {
        });
        DefaultListModel m = (DefaultListModel) Playlist.getModel();
        m.removeAllElements();
        MusicPaths = new ArrayList();
        File Music = new File("./Sistema/" + USER.getNombre() + USER.getCMusica());
        for (int i = 1; i < Music.listFiles().length + 1; i++) {
            if (Music.listFiles()[i - 1].getName().contains("mp3")) {
                MusicPaths.add(Music.listFiles()[i - 1].getPath());
                m.addElement(i + ".-  " + Music.listFiles()[i - 1].getName() + "\n");
            }
        }
        Playlist.setModel(m);
        MusicPlayer.pack();
        MusicPlayer.setLocationRelativeTo(this);
        MusicPlayer.setVisible(true);

    }//GEN-LAST:event_musicMouseClicked

    private void imMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imMouseClicked
        DefaultListModel m = (DefaultListModel) Contacts.getModel();
        m.removeAllElements();
        for (Usuario U : Users) {
            m.addElement(U);
        }
        Messenger.pack();
        Messenger.setLocationRelativeTo(this);
        Messenger.setVisible(true);
    }//GEN-LAST:event_imMouseClicked

    private void socialsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_socialsMouseClicked
        SocialMedia.pack();
        SocialMedia.setLocationRelativeTo(this);
        SocialMedia.setVisible(true);

    }//GEN-LAST:event_socialsMouseClicked

    private void recycleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recycleMouseClicked

        RecycleBin.pack();
        RecycleBin.setLocationRelativeTo(this);
        RecycleBin.setVisible(true);

    }//GEN-LAST:event_recycleMouseClicked

    private void m_newuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_newuserActionPerformed
        NewUser.pack();
        NewUser.setLocationRelativeTo(this);
        NewUser.setVisible(true);
    }//GEN-LAST:event_m_newuserActionPerformed

    private void SaveNewUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveNewUMouseClicked
        Usuario U;
        try {
            U = new Usuario(tf_newuname.getText(),
                    (Integer) s_edad.getValue(),
                    jd_newbday.getDate(),
                    tf_newunuser.getText(),
                    tf_newunpw.getText(),
                    tf_newunanswer.getText(),
                    tf_newuemail.getText(),
                    cb_question.getSelectedItem().toString(),
                    color.getBackground());
            UNs.add(tf_newunuser.getText());
            CreateSubDirs(U.getNombre());
            NewUser.setVisible(false);
            BinaryArchivesAdmin BAA = new BinaryArchivesAdmin("./User Information.aj");
            BAA.loadArchive();
            BAA.setUsuario(U);
            Users = BAA.getUsers();
            BAA.overrideArchive();
            Admin.setUsuarios(Users);
            JOptionPane.showMessageDialog(this, "¡Usuario creado exitósamente!");
        } catch (Exceptions e) {
            switch (e.getMessage()) {
                case "El nombre de usuario ingresado no está disponible.\nInténtelo de nuevo.":
                    JOptionPane.showMessageDialog(this, e.getMessage());
                    tf_newunuser.setForeground(Color.RED);
                    break;
                case "Contraseña Inválida.\nIngrese una nueva contraseña con al menos un número y una letra mayúscula.":
                    JOptionPane.showMessageDialog(this, e.getMessage());
                    tf_newunpw.setForeground(Color.RED);
                    break;
                case "El texto ingresado no es un correo.\nInténtelo de nuevo.":
                    JOptionPane.showMessageDialog(this, e.getMessage());
                    tf_newuemail.setForeground(Color.RED);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error desconocido. Inténtelo de nuevo.");
                    break;
            }
        }
    }//GEN-LAST:event_SaveNewUMouseClicked

    private void ClearField(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearField
        tf_newuname.setText("");
    }//GEN-LAST:event_ClearField

    private void tf_newunpwMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_newunpwMouseClicked
        tf_newunpw.setText("");
    }//GEN-LAST:event_tf_newunpwMouseClicked

    private void tf_newunuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_newunuserMouseClicked
        tf_newunuser.setText("");
    }//GEN-LAST:event_tf_newunuserMouseClicked

    private void tf_newunanswerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_newunanswerMouseClicked
        tf_newunanswer.setText("");
    }//GEN-LAST:event_tf_newunanswerMouseClicked

    private void tf_newuemailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_newuemailMouseClicked
        tf_newuemail.setText("");
    }//GEN-LAST:event_tf_newuemailMouseClicked

    private void estcolorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estcolorMouseClicked
        color.setBackground(JColorChooser.showDialog(this, "Seleccione un color predeterminado para el Sistema", Color.yellow));
    }//GEN-LAST:event_estcolorMouseClicked

    private void lockscreenpwMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lockscreenpwMouseClicked
        warning.setVisible(false);
    }//GEN-LAST:event_lockscreenpwMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (USER.getPW().equals(lockscreenpw.getText())) {
            LockUser.setVisible(false);
            this.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Contraseña incorrecta.");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void m_allusersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_allusersActionPerformed
        File Origin = new File("./Sistema");
        SetTrees(Origin, (DefaultMutableTreeNode) MainTree.getModel().getRoot());
        AdministrarUsuarios.pack();
        AdministrarUsuarios.setLocationRelativeTo(null);
        AdministrarUsuarios.setVisible(true);
    }//GEN-LAST:event_m_allusersActionPerformed

    private void AddImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddImagesActionPerformed
// aqui tira error pero idk why
        try {
            JFileChooser FChooser = new JFileChooser();
            FileFilter Filter;

            Filter = new FileNameExtensionFilter("Imágenes",
                    "png", "jpg", "jpeg", "gif");
            FChooser.setFileFilter(Filter);
            File archive;
            int op = FChooser.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                archive = FChooser.getSelectedFile();
                Image img = Toolkit.getDefaultToolkit().createImage(
                        archive.getPath()).getScaledInstance(-1, 373, 0);
                I.add(img);
                Files.copy(Paths.get(archive.getPath()),
                        Paths.get("./Sistema/"
                                + USER.getNombre()
                                + USER.getCImagenes() + "/"
                                + archive.getName()),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
        }
        if (i1 == false) {
            Icon1.setIcon((I.get(I.size() - 1)));
        } else if (i2 == false) {
            Icon2.setIcon((I.get(I.size() - 1)));
        } else if (i3 == false) {
            Icon3.setIcon((I.get(I.size() - 1)));
        }

    }//GEN-LAST:event_AddImagesActionPerformed

    private void jScrollPane5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane5MouseClicked
        if (evt.isMetaDown()) {
            this.ArchivesPM.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jScrollPane5MouseClicked

    private void TableArchivesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableArchivesMouseClicked
        DefaultTableModel m = (DefaultTableModel) TableArchives.getModel();
        String temp = "./";
        if (TableArchives.getSelectedRow() > -1) {
            if (evt.isMetaDown()) {
                ArchivesPM.show(TableArchives, evt.getX(), evt.getY());
                try {
                    for (Object object : TreeArchives.getSelectionPath().getPath()) {
                        temp += object.toString() + "/";
                    }
                } catch (Exception e) {
                    System.out.println("error " + temp);
                }
                modifiedpath = temp.substring(0, temp.length() - 1) + "/" + m.getValueAt(TableArchives.getSelectedRow(), 0);
                if (Paste.isEnabled()) {
                    modifiedpath2 = temp.substring(0, modifiedpath.length());
                }
                System.out.println("path1 " + modifiedpath);
                System.out.println("path2 " + modifiedpath2);
                Modified = new File(modifiedpath);
            }
        }
    }//GEN-LAST:event_TableArchivesMouseClicked

    private void TreeArchivesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TreeArchivesMouseClicked
        DefaultTableModel m2 = (DefaultTableModel) TableArchives.getModel();
        m2.setRowCount(0);

        TreeArchives.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent tse) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) TreeArchives.getLastSelectedPathComponent();
            }
        });
        String tipo = "";
        File f;
        try {
            for (Object object : TreeArchives.getSelectionPath().getPath()) {
                path += object.toString() + "/";
            }
        } catch (Exception e) {
        }
        path = path.substring(0, path.length() - 1);
        f = new File(path);
        if (f.listFiles() != null) {
            ArrayList<File> Folder = new ArrayList(Arrays.asList(f.listFiles()));
            for (File file : Folder) {
                try {
                    BasicFileAttributes attr = Files.readAttributes(Paths.get(file.getPath()), BasicFileAttributes.class);
                    if (file.getName().contains(".")) {
                        tipo = "Archivo " + file.getName().substring(file.getName().lastIndexOf("."));
                    } else {
                        tipo = "Carpeta de Archivos";
                    }
                    Object[] Directories = {file.getName(), attr.lastModifiedTime(), tipo, String.valueOf(attr.size() / 1000) + " KB"};
                    m2.addRow(Directories);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error al intentar localizar el archivo.");
                }

                TableArchives.setModel(m2);
            }
            path = "./";
        } else {
            try {
                BasicFileAttributes attr = Files.readAttributes(Paths.get(f.getPath()), BasicFileAttributes.class);
                if (f.getName().contains(".")) {
                    tipo = "Archivo " + f.getName().substring(f.getName().lastIndexOf("."));
                } else {
                    tipo = "Carpeta de Archivos";
                }
                Object[] Directories = {f.getName(), attr.lastModifiedTime(), tipo, String.valueOf(attr.size() / 1000) + " KB"};
                m2.addRow(Directories);

                TableArchives.setModel(m2);

            } catch (Exception ex) {
                Logger.getLogger(PP.class.getName()).log(Level.SEVERE, null, ex);
            }
            path = "./";
        }
        if (Paste.isEnabled()) {
            if (evt.isMetaDown()) {
                ArchivesPM.show(TreeArchives, evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_TreeArchivesMouseClicked

    private void archivesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_archivesActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if (pos3 == I.size() - 1) {
            jButton2.setEnabled(false);
        } else {
            ++pos1;
            ++pos2;
            ++pos3;
            ig1 = I.get(pos1);
            ig2 = I.get(pos2);
            ig3 = I.get(pos3);
            ig4 = ig1.getScaledInstance(190, 122, 0);
            ig5 = ig2.getScaledInstance(190, 122, 0);
            ig6 = ig3.getScaledInstance(190, 122, 0);
            Icon1.setIcon(new ImageIcon(ig4));
            Icon2.setIcon(new ImageIcon(ig5));
            Icon3.setIcon(new ImageIcon(ig6));
            jButton2.setEnabled(true);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void Icon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Icon1MouseClicked
        ImageIcon imageIcon = new ImageIcon(ig1);
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(-1, 373, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        MainImage.setIcon(imageIcon);
    }//GEN-LAST:event_Icon1MouseClicked

    private void Icon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Icon2MouseClicked
        ImageIcon imageIcon = new ImageIcon(ig2);
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(-1, 373, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        MainImage.setIcon(imageIcon);
    }//GEN-LAST:event_Icon2MouseClicked

    private void Icon3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Icon3MouseClicked
        ImageIcon imageIcon = new ImageIcon(ig3);
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(-1, 373, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        MainImage.setIcon(imageIcon);
    }//GEN-LAST:event_Icon3MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        if (pos1 == 0) {
            jButton3.setEnabled(false);
        } else {
            --pos1;
            --pos2;
            --pos3;
            ig1 = I.get(pos1);
            ig2 = I.get(pos2);
            ig3 = I.get(pos3);
            ig4 = ig1.getScaledInstance(190, 122, 0);
            ig5 = ig2.getScaledInstance(190, 122, 0);
            ig6 = ig3.getScaledInstance(190, 122, 0);
            Icon1.setIcon(new ImageIcon(ig4));
            Icon2.setIcon(new ImageIcon(ig5));
            Icon3.setIcon(new ImageIcon(ig6));
            jButton3.setEnabled(true);
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void ArchivesClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ArchivesClosed
        DefaultTableModel m = (DefaultTableModel) TableArchives.getModel();
        m.setRowCount(0);
        DefaultTreeModel m2 = new DefaultTreeModel(new DefaultMutableTreeNode("Sistema"));
        TreeArchives.setModel(m2);
        modifiedpath = "";
        modifiedpath = "";
    }//GEN-LAST:event_ArchivesClosed

    private void m_changebg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_changebg1ActionPerformed
        JFileChooser FChooser = new JFileChooser();
        FileFilter Filter = new FileNameExtensionFilter("Imágenes",
                "png", "jpg", "jpeg", "gif");
        FChooser.setFileFilter(Filter);
        File archive = null;
        int op = FChooser.showOpenDialog(this);
        if (op == JFileChooser.APPROVE_OPTION) {
            archive = FChooser.getSelectedFile();
        }
        ImageIcon newBG = new ImageIcon(archive.getPath());
        BG.setIcon(newBG);
        JOptionPane.showMessageDialog(this, "¡Cambios aplicados exitósamente!");
    }//GEN-LAST:event_m_changebg1ActionPerformed

    private void PreviousSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousSongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PreviousSongActionPerformed

    private void PlayPauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayPauseMouseClicked
        if (play) {
            if (!Playlist.isSelectionEmpty()) {
                URL source = Proyecto_AndreaMendoza.class.getResource("/Imagenes/pause-button.png");
                PlayPause.setIcon(new ImageIcon(source));
                MP.play();
                bm.setAvanzar(true);
                play = false;
            } else {
                JOptionPane.showMessageDialog(MusicPlayer, "No ha seleccionado ninguna canción.");
            }
        } else {
            URL source = Proyecto_AndreaMendoza.class.getResource("/Imagenes/play-button.png");
            PlayPause.setIcon(new ImageIcon(source));
            MP.pause();
            bm.setAvanzar(false);
            play = true;
        }
    }//GEN-LAST:event_PlayPauseMouseClicked

    private void ImportMusicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportMusicMouseClicked
        JFileChooser FChooser = new JFileChooser();
        DefaultListModel m = (DefaultListModel) Playlist.getModel();
        FileFilter Filter = new FileNameExtensionFilter("Archivos MP3",
                "mp3");
        FChooser.setFileFilter(Filter);
        try {
            int op = FChooser.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {

                Files.copy(Paths.get(FChooser.getSelectedFile().getPath()),
                        Paths.get("./Sistema/"
                                + USER.getNombre()
                                + USER.getCMusica() + "/"
                                + FChooser.getSelectedFile().getName()),
                        StandardCopyOption.REPLACE_EXISTING);
                MusicPaths.add("./Sistema/"
                        + USER.getNombre()
                        + USER.getCMusica() + "/"
                        + FChooser.getSelectedFile().getName());
                int i = MusicPaths.size();
                m.addElement(i + ".-  " + FChooser.getSelectedFile().getName() + "\n");
                Playlist.setModel(m);
                JOptionPane.showMessageDialog(MusicPlayer, "¡Archivo importado exitósamente!");
            }
        } catch (HeadlessException | IOException ex) {
            Logger.getLogger(PP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ImportMusicMouseClicked

    private void PlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlaylistMouseClicked
        if (flagthread) {
            MusicPB.setValue(0);
            bm.setAvanzar(false);
            MP.stop();
            flagthread = false;
        }
        URL source = Proyecto_AndreaMendoza.class.getResource("/Imagenes/pause-button.png");
        PlayPause.setIcon(new ImageIcon(source));

        PlaySong(new File(MusicPaths.get(Playlist.getSelectedIndex())));
    }//GEN-LAST:event_PlaylistMouseClicked

    private void MusicPlayerWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_MusicPlayerWindowClosing
        bm.stop();
        MP.stop();
    }//GEN-LAST:event_MusicPlayerWindowClosing

    private void NextSongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextSongMouseClicked
        if (Playlist.getSelectedIndex() + 1 <= Playlist.getLastVisibleIndex()) {
            Playlist.setSelectedIndex(Playlist.getSelectedIndex() + 1);
            if (flagthread) {
                MusicPB.setValue(0);
                bm.setAvanzar(false);
                MP.stop();
                flagthread = false;
            }
            URL source = Proyecto_AndreaMendoza.class.getResource("/Imagenes/pause-button.png");
            PlayPause.setIcon(new ImageIcon(source));
            PlaySong(new File(MusicPaths.get(Playlist.getSelectedIndex())));
        } else {
            Playlist.setSelectedIndex(Playlist.getMaxSelectionIndex());
            if (flagthread) {
                MusicPB.setValue(0);
                bm.setAvanzar(false);
                MP.stop();
                flagthread = false;
            }
            URL source = Proyecto_AndreaMendoza.class.getResource("/Imagenes/pause-button.png");
            PlayPause.setIcon(new ImageIcon(source));
            PlaySong(new File(MusicPaths.get(Playlist.getSelectedIndex())));
        }
    }//GEN-LAST:event_NextSongMouseClicked

    private void PreviousSongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PreviousSongMouseClicked
        if (Playlist.getSelectedIndex() - 1 >= Playlist.getFirstVisibleIndex()) {
            Playlist.setSelectedIndex(Playlist.getSelectedIndex() - 1);
            if (flagthread) {
                MusicPB.setValue(0);
                bm.setAvanzar(false);
                MP.stop();
                flagthread = false;
            }
            URL source = Proyecto_AndreaMendoza.class.getResource("/Imagenes/pause-button.png");
            PlayPause.setIcon(new ImageIcon(source));
            PlaySong(new File(MusicPaths.get(Playlist.getSelectedIndex())));
        } else {
            Playlist.setSelectedIndex(Playlist.getMinSelectionIndex());
            Playlist.setSelectedIndex(Playlist.getSelectedIndex() - 1);
            if (flagthread) {
                MusicPB.setValue(0);
                bm.setAvanzar(false);
                MP.stop();
                flagthread = false;
            }
            URL source = Proyecto_AndreaMendoza.class.getResource("/Imagenes/pause-button.png");
            PlayPause.setIcon(new ImageIcon(source));
            PlaySong(new File(MusicPaths.get(Playlist.getSelectedIndex())));
        }
    }//GEN-LAST:event_PreviousSongMouseClicked

    private void CopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopyActionPerformed
        Paste.setEnabled(true);
        Cut.setEnabled(false);
        Copy.setEnabled(false);
        copyflag = true;
    }//GEN-LAST:event_CopyActionPerformed

    private void PasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasteActionPerformed
        try {
            try {
                for (Object object : TreeArchives.getSelectionPath().getPath()) {
                    modifiedpath2 += object.toString() + "/";
                }
            } catch (Exception e) {
                System.out.println("error " + modifiedpath2);
            }
            modifiedpath2 = modifiedpath2.substring(0, modifiedpath2.lastIndexOf("/"));
            if (copyflag) {
                Files.copy(Paths.get(Modified.getPath()),
                        Paths.get(modifiedpath2 + "/" + Modified.getName()),
                        StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(Archives, "¡Documento copiado!");
            } else {
                Files.copy(Paths.get(Modified.getPath()),
                        Paths.get(modifiedpath2 + "/" + Modified.getName()),
                        StandardCopyOption.REPLACE_EXISTING);
                Files.delete(Paths.get(Modified.getPath()));
                JOptionPane.showMessageDialog(Archives, "¡Documento cortado!");
            }
        } catch (IOException ex) {
        }
        Cut.setEnabled(true);
        Copy.setEnabled(true);
        Archives.dispose();
        modifiedpath = "";
        modifiedpath2 = "";
        Paste.setEnabled(false);
    }//GEN-LAST:event_PasteActionPerformed

    private void CutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutActionPerformed
        Paste.setEnabled(true);
        Cut.setEnabled(false);
        Copy.setEnabled(false);
        copyflag = false;
    }//GEN-LAST:event_CutActionPerformed

    private void RenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RenameActionPerformed
        String NewName = JOptionPane.showInputDialog("Ingrese el nuevo nombre del archivo.") + Modified.getName().substring(Modified.getName().lastIndexOf("."));
        Path source = Paths.get(Modified.getPath());
        File Temp = new File(source.toString());
        if (Temp.isDirectory()) {
            String OG = Temp.getName();
            if (OG.contains(USER.getCCalendario())) {
                USER.setCCalendario("/" + NewName);
            } else if (OG.contains(USER.getCCorreo())) {
                USER.setCCorreo("/" + NewName);
            } else if (OG.contains(USER.getCMusica())) {
                USER.setCMusica("/" + NewName);
            } else if (OG.contains(USER.getCImagenes())) {
                USER.setCImagenes("/" + NewName);
            } else if (OG.contains(USER.getCDocumentos())) {
                USER.setCDocumentos("/" + NewName);
            } else if (OG.contains(USER.getCMensaje())) {
                USER.setCMensaje("/" + NewName);
            }
        }
        try {
            Files.move(source, source.resolveSibling(NewName));
        } catch (IOException ex) {
        }
        JOptionPane.showMessageDialog(Archives, "¡Nombre cambiado exitósamente!");
        Archives.dispose();
    }//GEN-LAST:event_RenameActionPerformed

    private void DeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseClicked

    }//GEN-LAST:event_DeleteMouseClicked

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        int resp = JOptionPane.showConfirmDialog(Archives, "¿En realidad desea eliminar el archivo?\nPodrá restaurar el documento desde la Papelera de Reciclaje siempre y cuando no apague el Sistema.");
        if (resp == JOptionPane.YES_OPTION) {
            try {
                String[] temp = new String[2];
                temp[0] = Modified.getPath();
                Files.copy(Paths.get(Modified.getPath()),
                        Paths.get("./Papelera de Reciclaje/" + Modified.getName()),
                        StandardCopyOption.REPLACE_EXISTING);
                Files.delete(Paths.get(Modified.getPath()));
                temp[1] = "./Papelera de Reciclaje/" + Modified.getName();
                Recycle.add(temp);
                JOptionPane.showMessageDialog(Archives, "¡Documento eliminado exitósamente!");
            } catch (IOException ex) {
                Logger.getLogger(PP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String tipo;
        DefaultTableModel m = (DefaultTableModel) RecycleBinTable.getModel();

        try {
            BasicFileAttributes attr = Files.readAttributes(Paths.get("./Papelera de Reciclaje/" + Modified.getName()), BasicFileAttributes.class);
            if (Modified.getName().contains(".")) {
                tipo = "Archivo " + Modified.getName().substring(Modified.getName().lastIndexOf("."));
            } else {
                tipo = "Carpeta de Archivos";
            }
            Object[] Directories = {Modified.getName(), attr.lastModifiedTime(), tipo, String.valueOf(attr.size() / 1000) + " KB"};
            m.addRow(Directories);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al intentar localizar el archivo.");
        }
        RecycleBinTable.setModel(m);
    }//GEN-LAST:event_DeleteActionPerformed

    private void RecycleBinTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecycleBinTableMouseClicked
        DefaultTableModel m = (DefaultTableModel) TableArchives.getModel();
        if (RecycleBinTable.getSelectedRow() > -1) {
            if (evt.isMetaDown()) {
                RBPM.show(RecycleBinTable, evt.getX(), evt.getY());
            }
        }

    }//GEN-LAST:event_RecycleBinTableMouseClicked

    private void jScrollPane7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane7MouseClicked

    private void DeletePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletePActionPerformed
        DefaultTableModel m = (DefaultTableModel) RecycleBinTable.getModel();
        try {
            Files.delete(Paths.get("./Papelera de Reciclaje/" + m.getValueAt(RecycleBinTable.getSelectedRow(), 0).toString()));
        } catch (IOException ex) {
        }
        JOptionPane.showMessageDialog(RecycleBin, "Archivo eliminado permanentemente.");
    }//GEN-LAST:event_DeletePActionPerformed

    private void RestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestoreActionPerformed
        DefaultTableModel m = (DefaultTableModel) RecycleBinTable.getModel();
        for (String[] s : Recycle) {
            for (String string : s) {
                if (string.contains(m.getValueAt(RecycleBinTable.getSelectedRow(), 0).toString())) {
                    if (USER instanceof Administrador) {
                        try {
                            Files.copy(Paths.get(Recycle.get(Recycle.indexOf(s))[1]), Paths.get(Recycle.get(Recycle.indexOf(s))[0]),
                                    StandardCopyOption.REPLACE_EXISTING);
                            Files.delete(Paths.get(Recycle.get(Recycle.indexOf(s))[1]));
                        } catch (IOException ex) {
                            Logger.getLogger(PP.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(RecycleBin, "¡Archivo restaurado exitósamente!");
                        break;
                    } else if (string.contains(USER.getNombre())) {
                        try {
                            Files.copy(Paths.get(Recycle.get(Recycle.indexOf(s))[1]), Paths.get(Recycle.get(Recycle.indexOf(s))[0]),
                                    StandardCopyOption.REPLACE_EXISTING);
                            Files.delete(Paths.get(Recycle.get(RecycleBinTable.getSelectedRow())[1]));
                        } catch (IOException ex) {
                            Logger.getLogger(PP.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(RecycleBin, "¡Archivo restaurado exitósamente!");
                    } else {
                        JOptionPane.showMessageDialog(RecycleBin, "No tiene permitido restaurar archivos que no hayan sido suyos.");
                    }
                }
            }
        }
    }//GEN-LAST:event_RestoreActionPerformed

    private void ConsoleTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ConsoleTextKeyPressed
        boolean a = false;
        Scanner c = new Scanner(ConsoleText.getText());
        String command = "";
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            while (c.hasNext()) {
                command = c.nextLine();
            }
            Scanner c2 = new Scanner(command);
            c2.useDelimiter(">");
            while (c2.hasNext()) {
                command = c2.next();
            }
            System.out.println(command);
            for (String cw : CodeWords) {
                if (command.contains(cw) || a == true) {
                    if (command.matches("mkdir<.*")) {
                        String[] temp = command.split("<");
                        String name = temp[1].substring(0, temp[1].length());
                        File nf = new File("./Sistema/" + USER.getNombre() + "/" + name);
                        nf.mkdir();
                        PathsNodes.add(nf.getPath());
                        ConsoleText.append("\n Directorio " + name + " creado.");
                        break;
                    } else if (command.matches("rm<.*")) {
                        String[] temp = command.split("<");
                        String name = temp[1].substring(0, temp[1].length());
                        for (String p : PathsNodes) {
                            if ((!(p.contains(name + "/")) && (p.contains(name)))) {
                                if ((USER instanceof Administrador) || (p.contains(USER.getNombre()))) {
                                    try {
                                        String[] temp2 = new String[2];
                                        temp2[0] = p;
                                        Files.copy(Paths.get(p),
                                                Paths.get("./Papelera de Reciclaje/" + name),
                                                StandardCopyOption.REPLACE_EXISTING);
                                        Files.delete(Paths.get(p));
                                        temp2[1] = "./Papelera de Reciclaje/" + name;
                                        Recycle.add(temp2);
                                        ConsoleText.append("\n Archivo " + name + " eliminado.");
                                        String tipo;
                                        DefaultTableModel m = (DefaultTableModel) RecycleBinTable.getModel();

                                        try {
                                            BasicFileAttributes attr = Files.readAttributes(Paths.get("./Papelera de Reciclaje/" + name), BasicFileAttributes.class);
                                            if (name.contains(".")) {
                                                tipo = "Archivo " + name.substring(name.lastIndexOf("."));
                                            } else {
                                                tipo = "Carpeta de Archivos";
                                            }
                                            Object[] Directories = {name, attr.lastModifiedTime(), tipo, String.valueOf(attr.size() / 1000) + " KB"};
                                            m.addRow(Directories);
                                        } catch (IOException ex) {
                                            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al intentar localizar el archivo.");
                                        }
                                        RecycleBinTable.setModel(m);
                                        break;
                                    } catch (IOException ex) {
                                        Logger.getLogger(PP.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                } else {
                                    ConsoleText.append("\nNo tiene acceso a este archivo.");
                                    break;
                                }
                            } else if (PathsNodes.indexOf(p) == PathsNodes.size() - 1) {
                                ConsoleText.append("\nNo se puede localizar el archivo.");
                                break;
                            }
                        }
                        break;
                    } else if (command.matches("cd<.*")) {
                        System.out.println("entra cd");
                        String[] temp = command.split("<");
                        String name = temp[1].substring(0, temp[1].length());
                        for (String p : PathsNodes) {
                            if ((!(p.contains(name + "/")) && (p.contains(name)))) {
                                if ((USER instanceof Administrador) || (p.contains(USER.getNombre()))) {
                                    currentpath = p;
                                    pathaesthetic = "\nSistema:\\" + p.substring(9) + ">";
                                    break;
                                } else if (PathsNodes.indexOf(p) == PathsNodes.size() - 1 && (!(p.contains(USER.getNombre())))) {
                                    ConsoleText.append("\nNo se puede localizar el archivo o no tiene acceso a él.");
                                    break;
                                }
                            }
                        }
                        break;
                    } else if (command.equalsIgnoreCase("cd..")) { // Corregir
                        File f = new File(currentpath);
                        if (f.getParent().contains("Sistema")) {
                            System.out.println(currentpath);
                            currentpath = currentpath.substring(0, currentpath.lastIndexOf("\\"));
                            System.out.println("antes " + currentpath);
                            int pos = 10;
                            if (currentpath.equalsIgnoreCase(".\\Sistema")) {
                                pos = 9;
                            }
                            pathaesthetic = "\nSistema:\\\\" + currentpath.substring(pos) + ">";
                        } else {
                            ConsoleText.append("\nHa llegado al archivo raíz.");
                            currentpath = "./Sistema";
                            pathaesthetic = "\nSistema:\\\\>";
                        }
                        break;
                    } else if (command.equalsIgnoreCase("time")) {
                        Date h = new Date();
                        DateFormat f = new SimpleDateFormat("hh:mm:ss a");
                        ConsoleText.append("\n La hora actual es: " + f.format(h));
                        break;
                    } else if (command.equalsIgnoreCase("date")) {
                        Date h = new Date();
                        DateFormat f = new SimpleDateFormat("EEEEE, MMMMM dd yyyy");
                        ConsoleText.append("\n La fecha actual es: " + f.format(h) + ".");
                        break;
                    } else if (command.equalsIgnoreCase("dir")) {
                        ConsoleText.append("\n\nDirectorio de " + pathaesthetic + "\n\n");
                        File D = new File(currentpath);
                        File[] Tabla = D.listFiles();
                        String tipo = "";
                        int contarchs = 0, bytearchs = 0, contdirs = 0, bytedirs = 0;
                        try {
                            for (File file : Tabla) {
                                BasicFileAttributes attr = Files.readAttributes(Paths.get(file.getPath()), BasicFileAttributes.class);
                                String size = String.format("%04d", attr.size());
                                if (attr.isDirectory()) {
                                    tipo = "<DIR>";
                                    ++contdirs;
                                    bytedirs += attr.size();
                                } else {
                                    ++contarchs;
                                    bytearchs += attr.size();
                                }
                                DateFormat date = new SimpleDateFormat("dd/mm/yyyy");
                                DateFormat time = new SimpleDateFormat("HH:mm");
                                ConsoleText.append(date.format(new Date(attr.creationTime().toMillis())) + "  " + time.format(new Date(attr.creationTime().toMillis())) + "  " + tipo + "  " + size + "  " + file.getName() + "\n");

                            }
                        } catch (IOException ex) {
                        }
                        ConsoleText.append("          " + contarchs + " archivos          " + bytearchs + " bytes\n          " + contdirs + " dirs          " + bytedirs + " bytes\n");
                        break;
                    } else if (command.equalsIgnoreCase("help")) {
                        ConsoleText.append("\n Instrucciones Válidas:\n"
                                + "  a. Mkdir <nombre>: Nueva carpeta.\n"
                                + "  b. Rm <nombre>: Eliminar carpeta.\n"
                                + "  c. Cd <nombre carpeta>: Cambiar de carpeta actual.\n"
                                + "  d. Cd.. Regresar de Carpeta.\n"
                                + "  e. Dir: Listar todas las carpetas y archivos en la carpeta actual.\n"
                                + "  f. Date: Ver fecha actual.\n"
                                + "  g. Time: Ver hora actual.\n");
                        break;
                    }
                } else if (CodeWords.indexOf(cw) == CodeWords.size() - 1) {
                    ConsoleText.append("\n INTRUCCIÓN INVÁLIDA. Escriba HELP para ver los comandos permitidos.\n\n");
                }
            }
            ConsoleText.append(pathaesthetic);
        }

    }//GEN-LAST:event_ConsoleTextKeyPressed

    private void StopButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StopButtonMouseClicked
        MP.stop();
        bm.setAvanzar(false);
        MusicPB.setValue(0);
    }//GEN-LAST:event_StopButtonMouseClicked

    private void txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMouseClicked
        if (evt.isMetaDown()) {
            TextPM.show(TextEditor, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_txtMouseClicked

    private void SendMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SendMMouseClicked
        boolean emptym = true;
        boolean emptyc = true;
        DefaultListModel m = (DefaultListModel) Contacts.getModel();
        if (Contacts.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(Messenger, "Por favor, selecciona un receptor del mensaje antes de continuar.");
            emptym = false;
        }
        if (Message.getText().equals("")) {
            JOptionPane.showMessageDialog(Messenger, "No puede enviar un mensaje en blanco.");
            emptyc = false;
        }
        if (emptym == true && emptyc == true) {
            U2 = (Usuario) m.getElementAt(Contacts.getSelectedIndex());
            String message = USER.getNombre() + ": " + Message.getText();
            Convo.append(message);
            Message.setText("");
            File convo = new File("./Sistema/" + USER.getNombre() + "/" + USER.getCMensaje() + "/Conversación con " + U2.getNombre() + ".txt");
            File convo2 = new File("./Sistema/" + U2.getNombre() + "/" + U2.getCMensaje() + "/Conversación con " + USER.getNombre() + ".txt");
            NormalDocsAdmin nd = new NormalDocsAdmin(convo, Message);
            NormalDocsAdmin nd2 = new NormalDocsAdmin(convo2, Message);
            nd.writeMessages();
            nd2.writeMessages();
            U2.setMsn(true);
        }
    }//GEN-LAST:event_SendMMouseClicked

    private void EditTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditTextActionPerformed
        GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();

        String[] allFonts = ge.getAvailableFontFamilyNames();
        DefaultListModel m = (DefaultListModel) fonts.getModel();
        for (String font : allFonts) {
            m.addElement(font);
        }
        FontChooser.pack();
        FontChooser.setLocationRelativeTo(null);
        FontChooser.setVisible(true);
    }//GEN-LAST:event_EditTextActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        FontChooser.setVisible(false);
    }//GEN-LAST:event_jButton4MouseClicked

    private void OkayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OkayMouseClicked
        StyledDocument doc = txt.getStyledDocument();
        Style estilo = txt.addStyle("miEstilo", null);
        StyleConstants.setForeground(estilo, muestra.getBackground());
        StyleConstants.setFontFamily(estilo, fonts.getSelectedValue());
        if (style.getSelectedValue().equals("Underline")) {
            StyleConstants.setUnderline(estilo, true);
        }
        if (style.getSelectedValue().equals("Bold") || style.getSelectedValue().equals("Bold Italic")) {
            StyleConstants.setBold(estilo, true);
        }
        if (style.getSelectedValue().equals("Italic") || style.getSelectedValue().equals("Bold Italic")) {
            StyleConstants.setItalic(estilo, true);
        }
        StyleConstants.setFontSize(estilo, Integer.parseInt(size.getSelectedValue()));
        doc.setCharacterAttributes(txt.getSelectionStart(),
                txt.getSelectionEnd() - txt.getSelectionStart(),
                txt.getStyle("miEstilo"),
                true);
        FontChooser.setVisible(false);
    }//GEN-LAST:event_OkayMouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        Color c = JColorChooser.showDialog(TextEditor, "Seleccione un color.", Color.yellow);
        muestra.setBackground(c);
    }//GEN-LAST:event_jButton5MouseClicked

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        try {
            JFileChooser FChooser = new JFileChooser("./Sistema/" + USER.getNombre() + "/" + USER.getCDocumentos());
            FileFilter Filter = new FileNameExtensionFilter("Documentos de Texto",
                    "txt");
            FChooser.setFileFilter(Filter);
            File archive = null;
            int op = FChooser.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                archive = FChooser.getSelectedFile();
            }

            TextDocAdmin TA = new TextDocAdmin(archive, txt);
            TA.loadArchive();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_OpenActionPerformed

    private void SaveDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveDocActionPerformed
        try {
            String name = JOptionPane.showInputDialog(TextEditor, "Ingrese un nombre para el documento.");
            File archive = new File("./Sistema/" + USER.getNombre() + "/" + USER.getCDocumentos() + "/" + name + ".txt");
            TextDocAdmin TA = new TextDocAdmin(archive, txt);
            TA.writeArchive();
        } catch (IOException ex) {
        } catch (BadLocationException ex) {
        }
        JOptionPane.showMessageDialog(TextEditor, "¡Documento guardado exitósamente!");
    }//GEN-LAST:event_SaveDocActionPerformed

    private void ContactsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContactsMouseClicked
        try {
            DefaultListModel m = (DefaultListModel) Contacts.getModel();
            U2 = (Usuario) m.getElementAt(Contacts.getSelectedIndex());
            File convo = new File("./Sistema/" + USER.getNombre() + "/" + USER.getCMensaje() + "/Conversación con " + U2.getNombre() + ".txt");
            NormalDocsAdmin nd = new NormalDocsAdmin(convo, Convo);
            nd.readMessages();
            Message.setText("");
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_ContactsMouseClicked

    private void TypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TypeItemStateChanged
        ++cbflag;
        if (cbflag == 2) {
            if (Type.getSelectedItem().toString().equals("Evento")) {
                start.setEnabled(true);
                end.setEnabled(true);
                Content.setEnabled(false);
                Notes.setEnabled(false);
            } else {
                Content.setEnabled(true);
                Notes.setEnabled(true);
                start.setEnabled(false);
                end.setEnabled(false);
            }
            cbflag = 0;
        }
    }//GEN-LAST:event_TypeItemStateChanged

    private void savedateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savedateMouseClicked
        boolean rec = false;
        int resp = JOptionPane.showConfirmDialog(Agenda, "¿Desea guardar un recordatorio para la actividad?");
        int mins = 0;
        if (resp == JOptionPane.YES_OPTION) {
            rec = true;
            mins = Integer.parseInt(JOptionPane.showInputDialog(Agenda, "Ingrese cuántos minutos antes de la actividad desea enviar una alarma."));
        }
        if (Type.getSelectedItem().toString().equals("Evento")) {
            USER.addAs(new Eventos(start.toString(), end.toString(), Fecha.getDate(), Title.getText(), rec, mins));
        } else if (Type.getSelectedIndex() != 0) {
            USER.addAs(new Tareas(Content.getText(), TempFiles, Fecha.getDate(), Title.getText(), rec, mins));
        }
        JOptionPane.showMessageDialog(Agenda, "¡Actividad guardada exitósamente.");
        Title.setText("");
        rec = false;
        mins = 0;
        Content.setText("");
        TempFiles = new ArrayList();
        Content.setEnabled(false);
        Notes.setEnabled(false);
        start.setEnabled(false);
        end.setEnabled(false);
        Type.setSelectedIndex(0);
    }//GEN-LAST:event_savedateMouseClicked

    private void calMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calMouseClicked
        DefaultTableModel m = (DefaultTableModel) agenda.getModel();
        for (Actividades a : USER.getAs()) {
            if (a.getDate().equals(cal.getDate())) {
                Object[] temp = {a.getClass().toString(), a.getTitle(), a.isReminder()};
                m.addRow(temp);
            }
        }
    }//GEN-LAST:event_calMouseClicked

    public void PlaySong(File song) {
        p = new Media(song.toURI().toString());
        MusicPB.setValue(0);
        MP = new MediaPlayer(p);
        MP.play();

        try {
            try {
                MP.setOnReady(new Runnable() {
                    @Override
                    public void run() {
                        double time = p.getDuration().toSeconds();
                        int min = (int) p.getDuration().toMinutes();
                        int secs = (int) time % 60;
                        String m = String.format("%02d", min);
                        String s = String.format("%02d", secs);
                        TotalTime.setText(m + ":" + s);
                        SongName.setText(song.getName());
                        MusicPB.setMaximum((int) p.getDuration().toSeconds());
                        flagthread = true;
                        bm.setAvanzar(true);
                        play = false;
                    }
                });
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }

    public static void main(String args[]) throws Exceptions {

        Calendar Cal = new GregorianCalendar(1999, 11, 24);
        Date bday = Cal.getTime();
 
        // ArrayList<Usuario> Usuarios, String Nombre, int Edad, Date Bday, String Username, String PW, String RespPW, String Correo, String Pregunta, Color C) throws Exceptions {

        /*METER ADMIN DONT DELETE JUST IN CASE
        BinaryArchivesAdmin BAA = new BinaryArchivesAdmin("./User Information.aj");
        BAA.loadArchive();     
        Administrador A = new Administrador(new ArrayList(), "Andrea J. Mendoza", 18, bday, "andreaj", "andreA1", "Rosado", "andreaj@unitec.edu", "¿Cuál es su color favorito?", new Color(255, 204, 255));
        BAA.getUsers().add(A);
        Users = BAA.getUsers();
        BAA.overrideArchive();
        System.out.println(BAA.getUsers());
         */
        
        BinaryArchivesAdmin BAA = new BinaryArchivesAdmin("./User Information.aj");
        BAA.loadArchive();
        Users = BAA.getUsers();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PP.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PP.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PP.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PP.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PP().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddImages;
    private javax.swing.JDialog AdministrarUsuarios;
    private javax.swing.JDialog Agenda;
    private javax.swing.JDialog Archives;
    private javax.swing.JPopupMenu ArchivesPM;
    private javax.swing.JLabel BG;
    private com.toedter.calendar.JCalendar CalendarBday;
    private javax.swing.JDialog ChangeBG;
    private javax.swing.JDialog Console;
    private javax.swing.JTextArea ConsoleText;
    private javax.swing.JList<String> Contacts;
    private javax.swing.JTextArea Content;
    private javax.swing.JTextArea Convo;
    private javax.swing.JMenuItem Copy;
    private javax.swing.JMenuItem Cut;
    private javax.swing.JMenu Date;
    private javax.swing.JMenuItem Delete;
    private javax.swing.JMenuItem DeleteP;
    private javax.swing.JMenu Edit;
    private javax.swing.JMenuItem EditText;
    private com.toedter.calendar.JDateChooser Fecha;
    private javax.swing.JMenu File;
    private javax.swing.JDialog FontChooser;
    private javax.swing.JMenu Help;
    private javax.swing.JLabel Icon1;
    private javax.swing.JLabel Icon2;
    private javax.swing.JLabel Icon3;
    private javax.swing.JDialog Icons;
    private javax.swing.JDialog Images;
    private javax.swing.JButton ImportMusic;
    private javax.swing.JDialog LockUser;
    private javax.swing.JFrame LogIn;
    private javax.swing.JLabel MainImage;
    private javax.swing.JToolBar MainMenu;
    private javax.swing.JTree MainTree;
    private javax.swing.JMenuBar MenuPrincipal;
    private javax.swing.JTextArea Message;
    private javax.swing.JDialog Messenger;
    private javax.swing.JProgressBar MusicPB;
    private javax.swing.JDialog MusicPlayer;
    private javax.swing.JDialog Netbeans;
    private javax.swing.JDialog NewBDay;
    private javax.swing.JDialog NewUser;
    private javax.swing.JButton NextSong;
    private javax.swing.JButton Notes;
    private javax.swing.JButton Okay;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenuItem Paste;
    private javax.swing.JButton PlayPause;
    private javax.swing.JList<String> Playlist;
    private javax.swing.JPopupMenu PopUpMain;
    private javax.swing.JButton PreviousSong;
    private javax.swing.JPopupMenu RBPM;
    private javax.swing.JDialog RecycleBin;
    private javax.swing.JTable RecycleBinTable;
    private javax.swing.JMenuItem Rename;
    private javax.swing.JMenuItem Restore;
    private javax.swing.JMenuItem Save;
    private javax.swing.JButton SaveBDay;
    private javax.swing.JMenuItem SaveDoc;
    private javax.swing.JButton SaveNewU;
    private javax.swing.JButton SendM;
    private javax.swing.JDialog SocialMedia;
    private javax.swing.JLabel SongName;
    private javax.swing.JLabel SongName1;
    private javax.swing.JButton StopButton;
    private javax.swing.JTable TableArchives;
    private javax.swing.JDialog TextEditor;
    private javax.swing.JPopupMenu TextPM;
    private javax.swing.JLabel Time;
    private javax.swing.JTextField Title;
    private javax.swing.JLabel TotalTime;
    private javax.swing.JTree TreeArchives;
    private javax.swing.JComboBox<String> Type;
    private javax.swing.JTable agenda;
    private javax.swing.JButton archives;
    private javax.swing.JButton b_cancel;
    private javax.swing.JButton b_login;
    private javax.swing.JButton b_shutdown;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg1;
    private javax.swing.JMenu blankspace;
    private com.toedter.calendar.JCalendar cal;
    private javax.swing.JButton calendar;
    private javax.swing.JComboBox<String> cb_question;
    private javax.swing.JLabel color;
    private javax.swing.JButton console;
    private javax.swing.JSpinner end;
    private javax.swing.JButton estcolor;
    private javax.swing.JList<String> fonts;
    private javax.swing.JMenuItem helpicons;
    private javax.swing.JButton im;
    private javax.swing.JButton images;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jb_forgotpw;
    private com.toedter.calendar.JDateChooser jd_newbday;
    private javax.swing.JTextField jt_userlogin;
    private javax.swing.JPasswordField lockscreenpw;
    private javax.swing.JMenu m_admin;
    private javax.swing.JMenu m_ajustes;
    private javax.swing.JMenuItem m_allusers;
    private javax.swing.JMenuItem m_bday;
    private javax.swing.JMenuItem m_changebg;
    private javax.swing.JMenuItem m_changebg1;
    private javax.swing.JMenuItem m_changecolor;
    private javax.swing.JMenuItem m_changecolor1;
    private javax.swing.JMenuItem m_email;
    private javax.swing.JMenuItem m_help;
    private javax.swing.JMenuItem m_lock;
    private javax.swing.JMenuItem m_logout;
    private javax.swing.JMenuItem m_newname;
    private javax.swing.JMenuItem m_newpw;
    private javax.swing.JMenuItem m_newun;
    private javax.swing.JMenuItem m_newuser;
    private javax.swing.JLabel muestra;
    private javax.swing.JButton music;
    private javax.swing.JLabel namelockscreen;
    private javax.swing.JButton netbeans;
    private javax.swing.JPasswordField pf_pwlogin;
    private javax.swing.JButton recycle;
    private javax.swing.JSpinner s_edad;
    private javax.swing.JButton savedate;
    private javax.swing.JList<String> size;
    private javax.swing.JButton socials;
    private javax.swing.JSpinner start;
    private javax.swing.JList<String> style;
    private javax.swing.JButton texteditor;
    private javax.swing.JTextField tf_newuemail;
    private javax.swing.JTextField tf_newuname;
    private javax.swing.JTextField tf_newunanswer;
    private javax.swing.JPasswordField tf_newunpw;
    private javax.swing.JTextField tf_newunuser;
    private javax.swing.JTextPane txt;
    private javax.swing.JLabel warning;
    // End of variables declaration//GEN-END:variables
private File Sistema;
    private int cnodes = 1;
    private ArrayList<String> PathsNodes = new ArrayList();
    private String path = "./";
    private final DefaultMutableTreeNode[] TreeNodes = new DefaultMutableTreeNode[2];
    private static Administrador Admin;
    ArrayList<Image> I = new ArrayList();
    int pos1 = 0;
    int pos2 = 1;
    int pos3 = 2;
    boolean i1 = false;
    boolean i2 = false;
    boolean i3 = false;
    Image ig1;
    Image ig2;
    Image ig3;
    Image ig4;
    Image ig5;
    Image ig6;
    boolean play = true;
    ArrayList<String> MusicPaths;
    Media p;
    MediaPlayer MP;
    BarMusic bm;
    boolean flag = false;
    boolean flagthread = false;
    File Modified;
    String modifiedpath = "./";
    String modifiedpath2 = "./";
    boolean copyflag = false;
    ArrayList<String[]> Recycle;
    ArrayList<String> CodeWords = new ArrayList();
    String currentpath;
    String pathaesthetic;
    Usuario U2;
    int cbflag = 0;
    ArrayList<Actividades> As = new ArrayList();
    ArrayList<File> TempFiles = new ArrayList();
}
